package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Producto;
import isil.edu.pe.proyectodonpedritomarket.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {
    
    @Autowired
    private ProductoRepositorio repositorio;

    public ProductoServicio(){}

    //Listar Productos
    public List<Producto> listarproductos(){
        return repositorio.findAll();
    }

    //Crear o Ingresar un Producto
    public Producto crearProducto(Producto producto){
        return repositorio.save(producto);
    }

    //Actualizar un producto
    public Producto actualizarProducto(Producto productoActualizar){
        Producto productoActual = repositorio.findById(productoActualizar.getIdProducto()).orElse(null);

        if (productoActualizar!=null) {
            productoActual.setNombre(productoActualizar.getNombre());
            productoActual.setPrecio(productoActualizar.getPrecio());
            productoActual.setStock(productoActualizar.getStock());
            productoActual.setCategoria(productoActualizar.getCategoria());
            productoActual.setProveedor(productoActualizar.getProveedor());

        }
        return repositorio.save(productoActual);
    }

    //Bucar Producto por ID
    public Producto buscarProductoPorID(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    //Eliminar una Producto por ID
    public void eliminarProductoPorID(Integer id){
        repositorio.deleteById(id);
    }
    
}

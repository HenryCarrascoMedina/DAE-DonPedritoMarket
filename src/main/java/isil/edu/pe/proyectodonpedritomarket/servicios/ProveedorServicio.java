package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Proveedor;
import isil.edu.pe.proyectodonpedritomarket.repositorios.ProveedorRepositorio;

@Service
public class ProveedorServicio {
    
    @Autowired
    private ProveedorRepositorio repositorio;

    public ProveedorServicio(){}

    //Listar Proveedores
    public List<Proveedor> listarProveedores(){
        return repositorio.findAll();
    }

    //Crear o Ingresar un Proveedor
    public Proveedor crearProveedor(Proveedor proveedor){
        return repositorio.save(proveedor);
    }

    //Actualizar un Proveedor
    public Proveedor actualizarProveedor(Proveedor proveedorActualizar){
        Proveedor proveedorActual=repositorio.findById(proveedorActualizar.getIdProveedor()).orElse(null);

        if (proveedorActualizar!=null) {
            proveedorActual.setNombre(proveedorActualizar.getNombre());
            proveedorActual.setContacto(proveedorActualizar.getContacto());
            proveedorActual.setTelefono(proveedorActualizar.getTelefono());
            proveedorActual.setCorreo(proveedorActualizar.getCorreo());
            proveedorActual.setDireccion(proveedorActualizar.getDireccion());
        }
        return repositorio.save(proveedorActual);
    } 

    //Buscar Proveedor por ID
    public Proveedor buscarProveedorPorID(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    //Borrar Proveedor por ID
    public void borrarProveedorPorID(Integer id){
        repositorio.deleteById(id);
    }
}

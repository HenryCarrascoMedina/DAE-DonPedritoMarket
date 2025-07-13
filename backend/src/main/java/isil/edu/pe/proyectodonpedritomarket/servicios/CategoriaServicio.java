package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Categoria;
import isil.edu.pe.proyectodonpedritomarket.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio repositorio;

    public CategoriaServicio(){
    }
    
    //Listar las categorias
    public List<Categoria> listarCategorias(){
        return repositorio.findAll();
    }

    //Crear o Ingresar una Categoria
    public Categoria crearCategoria(Categoria categoria){
        return repositorio.save(categoria);
    }

    //Actualizar una categoria
    public Categoria actualizarCategoria(Categoria categoriaActualizar){
        Categoria categoriaActual=repositorio.findById(categoriaActualizar.getIdCategoria()).orElse(null);

        if (categoriaActualizar!=null) {
            categoriaActual.setNombre(categoriaActualizar.getNombre());
            categoriaActual.setDescripcion(categoriaActualizar.getDescripcion());
        }
        return repositorio.save(categoriaActual);
    }

    //Bucar Categoria por ID
    public Categoria buscarCategoriaPorID(Integer idCategoria){
        return repositorio.findById(idCategoria).orElse(null);
    }

    //Eliminar una Categoria por ID
    public void borrarCategoriaPorID(Integer id){
        repositorio.deleteById(id);
    }
}

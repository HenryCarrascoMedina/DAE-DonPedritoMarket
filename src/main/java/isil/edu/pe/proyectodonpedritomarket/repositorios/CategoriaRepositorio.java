package isil.edu.pe.proyectodonpedritomarket.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{

    @Query("SELECT c FROM Categoria c WHERE c.nombre=?1")
    List<Categoria> buscarCategoriasPorNombre(String nombre);

    @Query("SELECT c FROM Categoria c WHERE c.nombre LIKE CONCAT(?1,'%')")
    List<Categoria> buscarCategoriaLikeNombre(String nombre);

}

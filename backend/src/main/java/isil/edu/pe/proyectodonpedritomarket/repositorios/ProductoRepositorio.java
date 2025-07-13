package isil.edu.pe.proyectodonpedritomarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

    //Agregare metodos si los necesito aqui...

}

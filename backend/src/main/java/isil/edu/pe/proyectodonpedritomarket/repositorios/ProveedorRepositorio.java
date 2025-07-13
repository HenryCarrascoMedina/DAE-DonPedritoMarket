package isil.edu.pe.proyectodonpedritomarket.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer>{
    
    List<Proveedor> findByNombre(String nombre);

    List<Proveedor> findByNombreContaining(String nombre);

}

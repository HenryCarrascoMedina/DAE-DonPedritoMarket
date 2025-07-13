package isil.edu.pe.proyectodonpedritomarket.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    
    List<Cliente> findByNombre(String nombre);

    List<Cliente> findByNombreContaining(String nombre);

    Optional<Cliente> findByCorreo(String correo);
}

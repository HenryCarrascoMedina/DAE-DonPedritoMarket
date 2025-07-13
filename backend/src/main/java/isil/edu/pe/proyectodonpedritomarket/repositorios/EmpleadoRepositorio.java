package isil.edu.pe.proyectodonpedritomarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Empleado;
import java.util.Optional;


@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{
	
    Optional<Empleado> findByCorreo(String correo);
	
}
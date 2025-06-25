package isil.edu.pe.proyectodonpedritomarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    
    Usuario findByCorreo(String correo);
    
}

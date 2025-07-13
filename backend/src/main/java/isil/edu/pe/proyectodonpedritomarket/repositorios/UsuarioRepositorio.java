package isil.edu.pe.proyectodonpedritomarket.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    
    Usuario findByCliente_IdCliente(int idCliente);

    Usuario findByEmpleado_IdEmpleado(int idEmpleado);
}

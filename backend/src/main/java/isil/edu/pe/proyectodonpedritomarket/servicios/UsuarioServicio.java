package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;
import isil.edu.pe.proyectodonpedritomarket.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    public UsuarioServicio() {}

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    // Buscar por ID
    public Usuario buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    // Crear nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    // Actualizar usuario existente
    public Usuario actualizarUsuario(Usuario usuarioActualizar) {
        Usuario usuarioActual = repositorio.findById(usuarioActualizar.getIdUsuario()).orElse(null);

        if (usuarioActual != null) {
            usuarioActual.setTipo(usuarioActualizar.getTipo());
            usuarioActual.setEmpleado(usuarioActualizar.getEmpleado());
            usuarioActual.setCliente(usuarioActualizar.getCliente());
            return repositorio.save(usuarioActual);
        }

        return null;
    }

    // Eliminar por ID
    public void eliminarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}

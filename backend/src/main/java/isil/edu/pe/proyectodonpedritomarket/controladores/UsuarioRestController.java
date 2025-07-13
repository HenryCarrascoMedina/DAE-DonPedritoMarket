package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;
import isil.edu.pe.proyectodonpedritomarket.servicios.UsuarioServicio;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioServicio servicio;

    // Listar todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return servicio.listarUsuarios();
    }

    // Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return servicio.crearUsuario(usuario);
    }

    // Obtener usuario por ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer idUsuario) {
        Usuario usuario = servicio.buscarPorId(idUsuario);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar usuario
    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario) {
        Usuario existente = servicio.buscarPorId(idUsuario);
        if (existente != null) {
            usuario.setIdUsuario(idUsuario);
            return ResponseEntity.ok(servicio.actualizarUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar usuario
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = servicio.buscarPorId(idUsuario);
        if (usuario != null) {
            servicio.eliminarPorId(idUsuario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isil.edu.pe.proyectodonpedritomarket.dtos.LoginRequest;
import isil.edu.pe.proyectodonpedritomarket.dtos.LoginResponse;
import isil.edu.pe.proyectodonpedritomarket.modelo.Cliente;
import isil.edu.pe.proyectodonpedritomarket.modelo.Empleado;
import isil.edu.pe.proyectodonpedritomarket.modelo.Usuario;
import isil.edu.pe.proyectodonpedritomarket.repositorios.ClienteRepositorio;
import isil.edu.pe.proyectodonpedritomarket.repositorios.EmpleadoRepositorio;
import isil.edu.pe.proyectodonpedritomarket.repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    
    @Autowired
    private ClienteRepositorio clienteRepo;
    @Autowired
    private EmpleadoRepositorio empleadoRepo;
    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        // Intentar login como cliente
        Optional<Cliente> cliente = clienteRepo.findByCorreo(request.getCorreo());
        if (cliente.isPresent() && cliente.get().getContrasena().equals(request.getContrasena())) {
            Usuario usuario = usuarioRepo.findByCliente_IdCliente(cliente.get().getIdCliente());
            return ResponseEntity.ok(
                new LoginResponse(
                    usuario.getIdUsuario(),
                    "cliente",
                    cliente.get().getNombre(),
                    null, // rolEmpleado
                    "Login exitoso"
                )
            );
        }

        // Intentar login como empleado
        Optional<Empleado> empleado = empleadoRepo.findByCorreo(request.getCorreo());
        if (empleado.isPresent() && empleado.get().getContrasena().equals(request.getContrasena())) {
            Usuario usuario = usuarioRepo.findByEmpleado_IdEmpleado(empleado.get().getIdEmpleado());
            return ResponseEntity.ok(
                new LoginResponse(
                    usuario.getIdUsuario(),
                    "empleado",
                    empleado.get().getNombre(),
                    empleado.get().getRol(), // rolEmpleado
                    "Login exitoso"
                )
            );
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }

}

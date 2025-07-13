package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import isil.edu.pe.proyectodonpedritomarket.modelo.Cliente;
import isil.edu.pe.proyectodonpedritomarket.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteServicio servicio;

    // 1. Listar todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return servicio.listarClientes();
    }

    // 2. Crear nuevo cliente
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return servicio.crearCliente(cliente);
    }

    // 3. Buscar cliente por ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable("idCliente") int idCliente) {
        Cliente cliente = servicio.buscarClientePorID(idCliente);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar cliente
    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("idCliente") int idCliente, @RequestBody Cliente cliente) {
        Cliente existente = servicio.buscarClientePorID(idCliente);
        if (existente != null) {
            cliente.setIdCliente(idCliente);
            return ResponseEntity.ok(servicio.crearCliente(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar cliente
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("idCliente") int idCliente) {
        Cliente cliente = servicio.buscarClientePorID(idCliente);
        if (cliente != null) {
            servicio.borrarClientePorID(idCliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


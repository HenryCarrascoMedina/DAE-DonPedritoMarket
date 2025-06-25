package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import isil.edu.pe.proyectodonpedritomarket.modelo.Proveedor;
import isil.edu.pe.proyectodonpedritomarket.servicios.ProveedorServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*") // Permitir peticiones desde cualquier frontend
public class ProveedorRestController {

    @Autowired
    private ProveedorServicio servicio;

    // 1. Listar todos los proveedores
    @GetMapping
    public List<Proveedor> listarProveedores() {
        return servicio.listarProveedores();
    }

    // 2. Crear nuevo proveedor
    @PostMapping
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return servicio.crearProveedor(proveedor);
    }

    // 3. Buscar proveedor por ID
    @GetMapping("/{idProveedor}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable int idProveedor) {
        Proveedor proveedor = servicio.buscarProveedorPorID(idProveedor);
        if (proveedor != null) {
            return ResponseEntity.ok(proveedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar proveedor
    @PutMapping("/{idProveedor}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable int idProveedor, @RequestBody Proveedor proveedor) {
        Proveedor existente = servicio.buscarProveedorPorID(idProveedor);
        if (existente != null) {
            proveedor.setIdProveedor(idProveedor); // mantener el ID correcto
            return ResponseEntity.ok(servicio.crearProveedor(proveedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar proveedor
    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable int idProveedor) {
        Proveedor proveedor = servicio.buscarProveedorPorID(idProveedor);
        if (proveedor != null) {
            servicio.borrarProveedorPorID(idProveedor);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import isil.edu.pe.proyectodonpedritomarket.modelo.Sucursal;
import isil.edu.pe.proyectodonpedritomarket.servicios.SucursalServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalRestController {

    @Autowired
    private SucursalServicio servicio;

    // 1. Listar todas las sucursales
    @GetMapping
    public List<Sucursal> listarSucursales() {
        return servicio.listarSucursales();
    }

    // 2. Crear nueva sucursal
    @PostMapping
    public Sucursal crearSucursal(@RequestBody Sucursal sucursal) {
        return servicio.crearSucursal(sucursal);
    }

    // 3. Buscar sucursal por ID
    @GetMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> obtenerSucursalPorId(@PathVariable int idSucursal) {
        Sucursal sucursal = servicio.buscarSucursalPorID(idSucursal);
        if (sucursal != null) {
            return ResponseEntity.ok(sucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar sucursal
    @PutMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable int idSucursal, @RequestBody Sucursal sucursal) {
        Sucursal existente = servicio.buscarSucursalPorID(idSucursal);
        if (existente != null) {
            sucursal.setIdSucursal(idSucursal); // aseguramos que se use el ID correcto
            return ResponseEntity.ok(servicio.crearSucursal(sucursal));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar sucursal
    @DeleteMapping("/{idSucursal}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable int idSucursal) {
        Sucursal sucursal = servicio.buscarSucursalPorID(idSucursal);
        if (sucursal != null) {
            servicio.borrarSucursalPorID(idSucursal);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


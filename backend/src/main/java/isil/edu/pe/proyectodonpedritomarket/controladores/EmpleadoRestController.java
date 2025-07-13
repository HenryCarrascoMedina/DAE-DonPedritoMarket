package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import isil.edu.pe.proyectodonpedritomarket.modelo.Empleado;
import isil.edu.pe.proyectodonpedritomarket.servicios.EmpleadoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServicio servicio;

    // 1. Listar todos los empleados
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return servicio.listarEmpleados();
    }

    // 2. Crear un nuevo empleado
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return servicio.crearEmpleado(empleado);
    }

    // 3. Buscar empleado por ID
    @GetMapping("/{idEmpleado}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable int idEmpleado) {
        Empleado empleado = servicio.buscarEmpleadoPorID(idEmpleado);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar empleado
    @PutMapping("/{idEmpleado}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int idEmpleado, @RequestBody Empleado empleado) {
        Empleado existente = servicio.buscarEmpleadoPorID(idEmpleado);
        if (existente != null) {
            empleado.setIdEmpleado(idEmpleado); // asegurar que se usa el mismo ID
            return ResponseEntity.ok(servicio.actualizarEmpleado(empleado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar empleado
    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable int idEmpleado) {
        Empleado empleado = servicio.buscarEmpleadoPorID(idEmpleado);
        if (empleado != null) {
            servicio.borrarEmpleadoPorID(idEmpleado);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

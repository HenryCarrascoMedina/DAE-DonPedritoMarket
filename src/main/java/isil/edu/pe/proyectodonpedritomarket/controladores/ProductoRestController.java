package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import isil.edu.pe.proyectodonpedritomarket.modelo.Producto;
import isil.edu.pe.proyectodonpedritomarket.servicios.ProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // permite que cualquier frontend acceda (útil en desarrollo)
public class ProductoRestController {

    @Autowired
    private ProductoServicio servicio;

    // 1. Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return servicio.listarproductos();
    }

    // 2. Crear un nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return servicio.crearProducto(producto);
    }

    // 3. Buscar producto por ID
    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int idProducto) {
        Producto producto = servicio.buscarProductoPorID(idProducto);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar producto
    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int idProducto, @RequestBody Producto producto) {
        Producto existente = servicio.buscarProductoPorID(idProducto);
        if (existente != null) {
            producto.setIdProducto(idProducto); // asegurar que se usa el mismo ID
            return ResponseEntity.ok(servicio.crearProducto(producto)); // se reutiliza el método guardar
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar producto
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int idProducto) {
        Producto producto = servicio.buscarProductoPorID(idProducto);
        if (producto != null) {
            servicio.eliminarProductoPorID(idProducto);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

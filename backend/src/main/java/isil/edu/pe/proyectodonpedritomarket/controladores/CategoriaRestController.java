package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import isil.edu.pe.proyectodonpedritomarket.modelo.Categoria;
import isil.edu.pe.proyectodonpedritomarket.servicios.CategoriaServicio;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {

    @Autowired
    private CategoriaServicio servicio;

    // 1. Listar todas las categorías
    @GetMapping
    public List<Categoria> listarCategorias() {
        return servicio.listarCategorias();
    }

    // 2. Crear una nueva categoría
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return servicio.crearCategoria(categoria);
    }

    // 3. Obtener una categoría por ID
    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable int idCategoria) {
        Categoria categoria = servicio.buscarCategoriaPorID(idCategoria);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. Actualizar una categoría
    @PutMapping("/{idCategoria}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable int idCategoria, @RequestBody Categoria categoria) {
        Categoria existente = servicio.buscarCategoriaPorID(idCategoria);
        if (existente != null) {
            categoria.setIdCategoria(idCategoria);
            return ResponseEntity.ok(servicio.crearCategoria(categoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Eliminar una categoría
    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable int idCategoria) {
        servicio.borrarCategoriaPorID(idCategoria);
        return ResponseEntity.noContent().build();
    }
}


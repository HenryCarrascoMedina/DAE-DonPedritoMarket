package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isil.edu.pe.proyectodonpedritomarket.modelo.Venta;
import isil.edu.pe.proyectodonpedritomarket.servicios.VentaServicio;

@RestController
@RequestMapping("/api/venta")
@CrossOrigin(origins = "*")
public class VentaRestController {

	@Autowired
	private VentaServicio servicio;
	
	@GetMapping
	public List<Venta> listarVentas(){
		return servicio.listarventas();
	}
	
	@PostMapping
	public Venta crearVenta(@RequestBody Venta venta) {
		return servicio.crearVenta(venta);
	}
	
	@GetMapping("/{idVenta}")
	public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable int idVenta){
		Venta venta = servicio.buscarVentaPorID(idVenta);
		if (venta != null) {
			return ResponseEntity.ok(venta);
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idVenta}")
	public ResponseEntity<Venta> actualizarVenta(@PathVariable int idVenta, @RequestBody Venta venta){
		Venta existente = servicio.buscarVentaPorID(idVenta);
		if (existente != null) {
			venta.setIdVenta(idVenta);
			return ResponseEntity.ok(servicio.crearVenta(venta));
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{idVenta}")
	public ResponseEntity<Venta> eliminarVenta(@PathVariable int idVenta){
		Venta venta = servicio.buscarVentaPorID(idVenta);
		if (venta != null) {
			servicio.eliminarVentaPorID(idVenta);
			return ResponseEntity.noContent().build();
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
}
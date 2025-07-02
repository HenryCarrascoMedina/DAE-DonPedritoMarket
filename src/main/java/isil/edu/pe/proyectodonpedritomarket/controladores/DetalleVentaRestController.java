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

import isil.edu.pe.proyectodonpedritomarket.modelo.DetalleVenta;
import isil.edu.pe.proyectodonpedritomarket.servicios.DetalleVentaServicio;

@RestController
@RequestMapping("/api/detalleventa")
@CrossOrigin(origins = "*")
public class DetalleVentaRestController {
	
	@Autowired
	private DetalleVentaServicio servicio;
	
	@GetMapping
	public List<DetalleVenta> listarDetalleVentas(){
		return servicio.listardetalleventas();
	}
	
	@PostMapping
	public DetalleVenta crearVenta(@RequestBody DetalleVenta detalleventa) {
		return servicio.crearDetalleVenta(detalleventa);
	}
	
	@GetMapping("/{idDetalleVenta}")
	public ResponseEntity<DetalleVenta> obtenerVentaPorId(@PathVariable int idDetalleVenta){
		DetalleVenta detalleventa = servicio.buscarDetalleVentaPorID(idDetalleVenta);
		if (detalleventa != null) {
			return ResponseEntity.ok(detalleventa);
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idDetalleVenta}")
	public ResponseEntity<DetalleVenta> actualizarDetalleVenta(@PathVariable int idDetalleVenta, @RequestBody DetalleVenta detalleventa){
		DetalleVenta existente = servicio.buscarDetalleVentaPorID(idDetalleVenta);
		if (existente != null) {
			detalleventa.setIdDetalleVenta(idDetalleVenta);
			return ResponseEntity.ok(servicio.crearDetalleVenta(detalleventa));
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{idDetalleVenta}")
	public ResponseEntity<DetalleVenta> eliminarDetalleVenta(@PathVariable int idDetalleVenta){
		DetalleVenta detalleventa = servicio.buscarDetalleVentaPorID(idDetalleVenta);
		if (detalleventa != null) {
			servicio.eliminarDetalleVentaPorID(idDetalleVenta);
			return ResponseEntity.noContent().build();
		}else {
			
		}
		return ResponseEntity.notFound().build();
	}

}
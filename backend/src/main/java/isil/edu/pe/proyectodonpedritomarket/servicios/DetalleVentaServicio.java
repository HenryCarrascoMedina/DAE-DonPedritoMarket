package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.DetalleVenta;
import isil.edu.pe.proyectodonpedritomarket.repositorios.DetalleVentaRepositorio;

@Service
public class DetalleVentaServicio {
	
	@Autowired
	private DetalleVentaRepositorio repositorio;
	
	public DetalleVentaServicio(){}
	
	public List<DetalleVenta> listardetalleventas(){
		return repositorio.findAll();
	}
	
	public DetalleVenta crearDetalleVenta(DetalleVenta detalleventa) {
		return repositorio.save(detalleventa);
	}
	
	public DetalleVenta actualizarDetalleVenta(DetalleVenta detalleventaActualizar) {
		 DetalleVenta detalleventaActual = repositorio.findById(detalleventaActualizar.getIdDetalleVenta()).orElse(null);
		 
		 if (detalleventaActualizar != null) {
			detalleventaActual.setCantidad(detalleventaActualizar.getCantidad());
			detalleventaActual.setPrecioUnitario(detalleventaActualizar.getPrecioUnitario());
			detalleventaActual.setSubtotal(detalleventaActualizar.getSubtotal());
			detalleventaActual.setProducto(detalleventaActualizar.getProducto());
			detalleventaActualizar.setVenta(detalleventaActualizar.getVenta());
			 
		 }
		 return repositorio.save(detalleventaActualizar);
	 }
	
	
	public DetalleVenta buscarDetalleVentaPorID(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public void eliminarDetalleVentaPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
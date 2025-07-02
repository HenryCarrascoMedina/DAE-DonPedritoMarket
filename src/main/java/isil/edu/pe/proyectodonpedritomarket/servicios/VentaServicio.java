package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Venta;
import isil.edu.pe.proyectodonpedritomarket.repositorios.VentaRepositorio;



@Service
public class VentaServicio {

	 @Autowired
	 private VentaRepositorio repositorio;
	 
	 public VentaServicio(){}
	 
	 public List<Venta> listarventas(){
		 return repositorio.findAll();
	 }
	 
	 public Venta crearVenta(Venta venta) {
		 return repositorio.save(venta);
	 }
	 
	 public Venta actualizarVenta(Venta ventaActualizar) {
		 Venta ventaActual = repositorio.findById(ventaActualizar.getIdVenta()).orElse(null);
		 
		 if (ventaActualizar != null) {
			 ventaActual.setFechaVenta(ventaActualizar.getFechaVenta());
			 ventaActual.setTotal(ventaActualizar.getTotal());
			 ventaActual.setMetodoPago(ventaActualizar.getMetodoPago());
			 ventaActual.setEstado(ventaActualizar.getEstado());
			 ventaActual.setUsuario(ventaActualizar.getUsuario());
			 ventaActual.setSucursal(ventaActualizar.getSucursal());
			 
		 }
		 return repositorio.save(ventaActualizar);
	 }
	 
	 public Venta buscarVentaPorID(Integer id) {
		 return repositorio.findById(id).orElse(null);
	 }
	
	 public void eliminarVentaPorID(Integer id) {
		 repositorio.deleteById(id);
	 }
}
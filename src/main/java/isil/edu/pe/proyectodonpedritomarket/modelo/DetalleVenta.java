package isil.edu.pe.proyectodonpedritomarket.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="detalle_venta")
public class DetalleVenta {
	
	@Id
    @Column(name="id_detalle_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
	
	 @Column(name="precio_unitario")
	    private BigDecimal precioUnitario;
	
	 @Column(name="subtotal")
	    private BigDecimal subtotal;
	 
	 @Column(name="cantidad")
	    private Integer cantidad;
	 
	 @ManyToOne
	    @JoinColumn(name = "id_venta")
	    private Venta venta;
	 
	 @ManyToOne
	    @JoinColumn(name = "id_producto")
	    private Producto producto;
	 
	
	public DetalleVenta() {
		
	}

	public DetalleVenta(Integer idDetalleVenta, BigDecimal precioUnitario, BigDecimal subtotal, Integer cantidad,
			Venta venta, Producto producto) {
		this.idDetalleVenta = idDetalleVenta;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
		this.cantidad = cantidad;
		this.venta = venta;
		this.producto = producto;
	}

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
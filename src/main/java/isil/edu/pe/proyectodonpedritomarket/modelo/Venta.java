package isil.edu.pe.proyectodonpedritomarket.modelo;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="venta")
public class Venta {
	
	@Id
    @Column(name="id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
	
    @Column(name="fecha_venta")
    private Date fechaVenta;
    
    @Column(name="total")
    private BigDecimal total;
	
    @Column(name="metodo_pago")
    private String metodoPago;
    
    @Column(name="estado")
    private String estado;
   
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    
    public Venta() {
    	
    }


	public Venta(Integer idVenta, Date fechaVenta, BigDecimal total, String metodoPago, String estado,
			Usuario usuario, Sucursal sucursal) {
		super();
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.total = total;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.usuario = usuario;
		this.sucursal = sucursal;
	}


	public Integer getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public String getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Sucursal getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
    
  
}
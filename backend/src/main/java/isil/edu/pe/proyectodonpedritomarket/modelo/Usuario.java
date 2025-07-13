package isil.edu.pe.proyectodonpedritomarket.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "tipo")
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Constructores
    public Usuario() {
    }

    public Usuario(Integer idUsuario, String tipo, Empleado empleado, Cliente cliente) {
		this.idUsuario = idUsuario;
		this.tipo = tipo;
		this.empleado = empleado;
		this.cliente = cliente;
	}

	//Getters y Setters
    
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
}

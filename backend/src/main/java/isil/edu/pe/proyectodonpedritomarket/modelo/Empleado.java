package isil.edu.pe.proyectodonpedritomarket.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado{
	
	@Id
	@Column(name="id_empleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;
	@Column(name="nombre")
    private String nombre;
	@Column(name="correo")
    private String correo;
	@Column(name="contrasena")
    private String contrasena;
	@Column(name="rol")
    private String rol;
	@ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
	
	public Empleado() {
	}

	public Empleado(Integer idEmpleado, String nombre, String correo, String contrasena, String rol, Sucursal sucursal) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.rol = rol;
		this.sucursal= sucursal;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
}
	

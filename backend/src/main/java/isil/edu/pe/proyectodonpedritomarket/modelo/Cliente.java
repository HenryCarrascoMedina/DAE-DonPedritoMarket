package isil.edu.pe.proyectodonpedritomarket.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    
    //Atributos
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(name="nombre")
    private String nombre;
    @Column(name="correo")
    private String correo;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="documento")
    private String documento;
    @Column(name="telefono")
    private String telefono;
    @Column(name="direccion")
    private String direccion;

    //Constructores
    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String correo, String contrasena, String documento, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo=correo;
        this.contrasena=contrasena;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //Getters y Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
}

package isil.edu.pe.proyectodonpedritomarket.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="proveedor")
public class Proveedor {

    //Atributos
    @Id
    @Column(name = "id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "telefono") 
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;

    //Constructores
    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String nombre, String contacto, String telefono, String correo,
            String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    //Getters y Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", contacto=" + contacto + ", telefono="
                + telefono + ", correo=" + correo + ", direccion=" + direccion + "]";
    } 

    
    
    
}

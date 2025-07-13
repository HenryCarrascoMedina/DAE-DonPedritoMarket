package isil.edu.pe.proyectodonpedritomarket.dtos;

public class LoginResponse {
    private int idUsuario;
    private String tipo; // "cliente" o "empleado"
    private String nombre;
    private String rolEmpleado; // null si es cliente
    private String mensaje;
    
    public LoginResponse() {
    }

    public LoginResponse(int idUsuario, String tipo, String nombre, String rolEmpleado, String mensaje) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.rolEmpleado = rolEmpleado;
        this.mensaje = mensaje;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

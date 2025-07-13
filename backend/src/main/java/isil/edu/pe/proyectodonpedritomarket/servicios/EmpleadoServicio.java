package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Empleado;
import isil.edu.pe.proyectodonpedritomarket.repositorios.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio repositorio;

    public EmpleadoServicio(){}

    // Listar Empleados
    public List<Empleado> listarEmpleados() {
        return repositorio.findAll();
    }

    // Crear o Ingresar un Empleado
    public Empleado crearEmpleado(Empleado empleado) {
        return repositorio.save(empleado);
    }

    // Actualizar un Empleado
    public Empleado actualizarEmpleado(Empleado empleadoActualizar) {
        Empleado empleadoActual = repositorio.findById(empleadoActualizar.getIdEmpleado()).orElse(null);

        if (empleadoActual != null) {
            empleadoActual.setNombre(empleadoActualizar.getNombre());
            empleadoActual.setCorreo(empleadoActualizar.getCorreo());
            empleadoActual.setContrasena(empleadoActualizar.getContrasena());
            empleadoActual.setRol(empleadoActualizar.getRol());
            empleadoActual.setSucursal(empleadoActualizar.getSucursal());
        }
        return repositorio.save(empleadoActual);
    }

    // Buscar Empleado por ID
    public Empleado buscarEmpleadoPorID(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    // Eliminar un Empleado por ID
    public void borrarEmpleadoPorID(Integer id) {
        repositorio.deleteById(id);
    }
}

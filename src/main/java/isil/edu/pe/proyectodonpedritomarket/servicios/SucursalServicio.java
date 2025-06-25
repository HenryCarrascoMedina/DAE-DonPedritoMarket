package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Sucursal;
import isil.edu.pe.proyectodonpedritomarket.repositorios.SucursalRepositorio;

@Service
public class SucursalServicio {
//Aqui va todo el CRUD
    
    @Autowired
    private SucursalRepositorio repositorio;

    public SucursalServicio(){}

    //Listar Sucursales
    public List<Sucursal> listarSucursales(){
        return repositorio.findAll();
    }

    //Crear o Ingresar una Sucursal
    public Sucursal crearSucursal(Sucursal sucursal){
        return repositorio.save(sucursal);
    }

    //Actualizar una Sucursal
    public Sucursal actualizarSucursal(Sucursal sucursalActualizar){
        Sucursal sucursalActual=repositorio.findById(sucursalActualizar.getIdSucursal()).orElse(null);

        if (sucursalActualizar!=null) {
            sucursalActual.setNombre(sucursalActualizar.getNombre());
            sucursalActual.setDireccion(sucursalActualizar.getDireccion());
            sucursalActual.setTelefono(sucursalActualizar.getTelefono());
        }
        return repositorio.save(sucursalActual);
    }

    //Buscar Proveedor por ID
    public Sucursal buscarSucursalPorID(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    //Borrar Proveedor por ID
    public void borrarSucursalPorID(Integer id){
        repositorio.deleteById(id);
    }
}

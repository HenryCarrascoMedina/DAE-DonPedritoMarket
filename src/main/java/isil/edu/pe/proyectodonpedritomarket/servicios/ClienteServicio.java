package isil.edu.pe.proyectodonpedritomarket.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isil.edu.pe.proyectodonpedritomarket.modelo.Cliente;
import isil.edu.pe.proyectodonpedritomarket.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio repositorio;

    public ClienteServicio(){}

    //Listar Clientes
    public List<Cliente> listarClientes(){
        return repositorio.findAll();
    } 

    //Crear o Ingresar una Categoria
    public Cliente crearCliente(Cliente cliente){
        return repositorio.save(cliente);
    }

    //Actualizar un Cliente
    public Cliente actualizarCliente(Cliente clienteActualizar){
        Cliente clienteActual=repositorio.findById(clienteActualizar.getIdCliente()).orElse(null);

        if (clienteActualizar!=null) {
            clienteActual.setNombre(clienteActualizar.getNombre());
            clienteActual.setDocumento(clienteActualizar.getDocumento());
            clienteActual.setTelefono(clienteActualizar.getTelefono());
            clienteActual.setDireccion(clienteActualizar.getDireccion());
        }
        return repositorio.save(clienteActual);
    }

    //Bucar Cliente por ID
    public Cliente buscarClientePorID(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    //Eliminar una Cliente por ID
    public void borrarClientePorID(Integer id){
        repositorio.deleteById(id);
    }
}

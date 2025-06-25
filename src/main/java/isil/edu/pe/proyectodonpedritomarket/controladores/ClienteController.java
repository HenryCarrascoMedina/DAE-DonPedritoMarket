package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import isil.edu.pe.proyectodonpedritomarket.modelo.Cliente;
import isil.edu.pe.proyectodonpedritomarket.servicios.ClienteServicio;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteServicio servicio;
    
    @RequestMapping("/listarTodo")
    public String listarClientes(Model model){
        List<Cliente> listarClientes = servicio.listarClientes();
        model.addAttribute("listarClientes", listarClientes);
        return "moduloCliente/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevoCliente(Model model) {
        Cliente cliente = new Cliente();   
        model.addAttribute("cliente", cliente);
        return "moduloCliente/nuevoCliente";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
        servicio.crearCliente(cliente);
        return "redirect:/cliente/listarTodo";
    }

    @RequestMapping(value = "/actualizar/{idCliente}")
    public ModelAndView editarCliente(@PathVariable(name="idCliente")int idCliente){
        ModelAndView mav = new ModelAndView("/moduloCliente/editarCliente");
        Cliente cliente = servicio.buscarClientePorID(idCliente);
        mav.addObject("cliente", cliente);
        return mav;
    }

    @RequestMapping(value="/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable(name = "idCliente")int idCliente) {
        servicio.borrarClientePorID(idCliente);
        return "redirect:/cliente/listarTodo";
    }
    
}

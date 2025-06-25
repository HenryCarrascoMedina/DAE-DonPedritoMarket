package isil.edu.pe.proyectodonpedritomarket.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import isil.edu.pe.proyectodonpedritomarket.modelo.Proveedor;
import isil.edu.pe.proyectodonpedritomarket.servicios.ProveedorServicio;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorServicio servicio;

    @RequestMapping("/listarTodo")
    public String listarProveedor(Model model){
        List<Proveedor> listarProveedores = servicio.listarProveedores();
        model.addAttribute("listarProveedores", listarProveedores);
        return "moduloProveedor/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevoProveedor(Model model){
        Proveedor proveedor = new Proveedor();
        model.addAttribute("proveedor", proveedor);
        return "moduloProveedor/nuevoProveedor";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearProveedor(@ModelAttribute("proveedor") Proveedor proveedor){
        servicio.crearProveedor(proveedor);
        return "redirect:/proveedor/listarTodo";
    }

    @RequestMapping(value = "actualizar/{idProveedor}")
    public ModelAndView editarProveedor(@PathVariable(name = "idProveedor") int idProveedor){
        ModelAndView mav = new ModelAndView("/moduloProveedor/editarProveedor");
        Proveedor proveedor = servicio.buscarProveedorPorID(idProveedor);
        mav.addObject("proveedor", proveedor);
        return mav;
    }

    @RequestMapping(value = "eliminar/{idProveedor}")
    public String eliminarProveedor(@PathVariable(name="idProveedor") int idProveedor){
        servicio.borrarProveedorPorID(idProveedor);
        return "redict:/proveedor/listarTodo";
    }
    
}

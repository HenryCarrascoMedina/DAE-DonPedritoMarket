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

import isil.edu.pe.proyectodonpedritomarket.modelo.Sucursal;
import isil.edu.pe.proyectodonpedritomarket.servicios.SucursalServicio;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
    
    @Autowired
    SucursalServicio servicio;

    @RequestMapping("/listarTodo")
    public String listarSucursales(Model model){
        List<Sucursal> listarSucursales = servicio.listarSucursales();
        model.addAttribute("listarSucursales", listarSucursales);
        return "moduloSucursal/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevaSucursal(Model model){
        Sucursal sucursal = new Sucursal();
        model.addAttribute("sucursal", sucursal);
        return "moduloSucursal/nuevoSucursal";
    }

    @RequestMapping(value = "/guardar", method=RequestMethod.POST)
    public String crearSucursal(@ModelAttribute("sucursal")Sucursal sucursal){
        servicio.crearSucursal(sucursal);
        return "redirect:/sucursal/listarTodo";
    }

    @RequestMapping(value = "actualizar/{idSucursal}")
    public ModelAndView editarSucursal(@PathVariable(name = "idSucursal")int idSucursal){
        ModelAndView mav = new ModelAndView("/moduloSucursal/editarSucursal");
        Sucursal sucursal = servicio.buscarSucursalPorID(idSucursal);
        mav.addObject("sucursal", sucursal);
        return mav;
    }

    @RequestMapping(value = "eliminar/{idSucursal}")
    public String eliminarSucursal(@PathVariable(name = "idSucursal")int idSucursal){
        servicio.borrarSucursalPorID(idSucursal);
        return "redirect:/sucursal/listarTodo";
    }
}

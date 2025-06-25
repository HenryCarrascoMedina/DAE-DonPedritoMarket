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

import isil.edu.pe.proyectodonpedritomarket.modelo.Categoria;
import isil.edu.pe.proyectodonpedritomarket.servicios.CategoriaServicio;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaServicio servicio;

    @RequestMapping("/listarTodo")
    public String listarCategorias(Model model){
        List<Categoria> listarCategorias = servicio.listarCategorias();
        model.addAttribute("listarCategorias", listarCategorias);
        return "moduloCategoria/listarTodo";
    }
    
    @RequestMapping("/nuevo")
    public String nuevaCategoria(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        return "/moduloCategoria/nuevaCategoria";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
        servicio.crearCategoria(categoria);
        return "redirect:/categoria/listarTodo";
    }

    @RequestMapping(value = "/actualizar/{idCategoria}")
    public ModelAndView editarCategoria(@PathVariable(name = "idCategoria") int idCategoria) {
        ModelAndView mav = new ModelAndView("/moduloCategoria/editarCategoria");
        Categoria categoria = servicio.buscarCategoriaPorID(idCategoria);
        mav.addObject("categoria", categoria);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{idCategoria}")
    public String eliminarCategoria(@PathVariable(name = "idCategoria") int idCategoria) {
        servicio.borrarCategoriaPorID(idCategoria);
        return "redirect:/categoria/listarTodo";
    }
}

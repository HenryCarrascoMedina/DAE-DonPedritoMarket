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
import isil.edu.pe.proyectodonpedritomarket.modelo.Producto;
import isil.edu.pe.proyectodonpedritomarket.modelo.Proveedor;
import isil.edu.pe.proyectodonpedritomarket.servicios.CategoriaServicio;
import isil.edu.pe.proyectodonpedritomarket.servicios.ProductoServicio;
import isil.edu.pe.proyectodonpedritomarket.servicios.ProveedorServicio;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    CategoriaServicio categoriaServicio;
    @Autowired
    ProveedorServicio proveedorServicio;
    @Autowired
    ProductoServicio servicio;

    ProductoController(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    @RequestMapping("/listarTodo")
    public String listarProductos(Model model){
        List<Producto> listarProductos = servicio.listarproductos();
        model.addAttribute("listarProductos", listarProductos);
        return "moduloProducto/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevoProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listaCategorias", categoriaServicio.listarCategorias());
        model.addAttribute("listaProveedores", proveedorServicio.listarProveedores());
        return "moduloProducto/nuevoProducto";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearProducto(@ModelAttribute("producto")Producto producto){
        servicio.crearProducto(producto);
        return "redirect:/producto/listarTodo";
    }

    @RequestMapping(value = "/actualizar/{idProducto}")
    public ModelAndView editarProducto(@PathVariable(name = "idProducto")int idProducto){
        ModelAndView mav = new ModelAndView("/moduloProducto/editarProducto");
        Producto producto = servicio.buscarProductoPorID(idProducto);
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        List<Proveedor> proveedores = proveedorServicio.listarProveedores();
        mav.addObject("producto", producto);
        mav.addObject("listaCategorias", categorias);
        mav.addObject("listaProveedores", proveedores);
        return mav;
    }
    
    @RequestMapping(value = "/eliminar/{idProducto}")
    public String eliminarProducto(@PathVariable(name = "idProducto")int idProducto){
        servicio.eliminarProductoPorID(idProducto);
        return "redirect:/producto/listarTodo";
    }
}

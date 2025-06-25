package isil.edu.pe.proyectodonpedritomarket.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Se refiere a login.html en templates
    }
}

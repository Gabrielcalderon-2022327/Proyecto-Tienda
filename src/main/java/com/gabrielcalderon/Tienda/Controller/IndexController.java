package com.gabrielcalderon.Tienda.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String mostrarIndex(HttpSession session){
        //Validar Sesion
        if(session.getAttribute("usuarioLogueado") == null){
            return "redirect:/login";
        }
        return "index";
    }

    
}

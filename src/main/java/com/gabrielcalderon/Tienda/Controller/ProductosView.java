package com.gabrielcalderon.Tienda.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductosView {
    @GetMapping("/productos")
    public String cargarProductos(HttpSession session){
        if(session.getAttribute("usuarioLogueado") == null){
            return "redirect:/login";
        }
        return "Productos";
    }
}

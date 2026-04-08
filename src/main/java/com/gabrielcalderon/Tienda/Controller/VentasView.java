package com.gabrielcalderon.Tienda.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentasView {
    @GetMapping("/ventas")
    public String cargarClientes(HttpSession session, Model model){
        if(session.getAttribute("usuarioLogueado") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("username"));
        return "Ventas";
    }
}

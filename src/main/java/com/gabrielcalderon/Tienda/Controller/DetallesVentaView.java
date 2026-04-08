package com.gabrielcalderon.Tienda.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetallesVentaView {
    @GetMapping("/detalles")
    public String cargarDetalles(HttpSession session){
        if(session.getAttribute("usuarioLogueado") == null){
            return "redirect:/login";
        }
        return "DetalleVenta";
    }
}

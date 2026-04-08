package com.gabrielcalderon.Tienda.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/")
    public String inicio(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarLogin(){
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String password, HttpSession sesion, Model model){
        String userCorrecto = "admin";
        String passCorrecto = "1234";

        if (usuario.equals(userCorrecto) && password.equals(passCorrecto)){
            //Guardar sesion
            sesion.setAttribute("usuarioLogueado", usuario);
            return "redirect:/index";
        } else {
            model.addAttribute("error:", "Usuario y contraseña incorrectas");
            return "Login";
        }
    }
}

package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import com.gabrielcalderon.Tienda.Service.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UsuariosService service;

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
        Usuarios user = service.login(usuario, password);

        if (user != null) {
            sesion.setAttribute("currentUser", usuario);
            sesion.setAttribute("rol", user.getRol());
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "Login";
        }
    }

    @GetMapping("/register")
    public String mostrarRegister(){
        return "Register";
    }

    @PostMapping("/register")
    public String registrarse(@RequestParam String mail, @RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword, Model model){
        if(!password.equals(confirmPassword)){
            model.addAttribute("error", "La contraseña no coincide");
            return "Register";
        }
        Usuarios newUser = new Usuarios();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(mail);
        newUser.setRol("user");
        newUser.setEstado(1);
        service.addUsuario(newUser);
        return "redirect:/login";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuarioLogueado", null);
        return "redirect:/login";
    }
}

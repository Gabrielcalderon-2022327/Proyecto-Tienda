package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import com.gabrielcalderon.Tienda.Service.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    private UsuariosService service;

    @GetMapping("/usuarios")
    public String cargarUsuarios(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        if (session.getAttribute("rol") != "admin"){
            return "redirect:/index";
        }

        model.addAttribute("username", session.getAttribute("currentUser"));
        model.addAttribute("rol", session.getAttribute("rol"));

        if (!model.containsAttribute("usuarios")) {
            model.addAttribute("usuarios", service.getAllUsuarios());
        }

        return "Usuarios";
    }

    @GetMapping("/usuarios/listar")
    public String listarUsuarios(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("usuarios", service.getAllUsuarios());
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/crear")
    public String crearUsuario(RedirectAttributes redirectAttributes,
                               @RequestParam String create_username,
                               @RequestParam String create_password,
                               @RequestParam String create_email,
                               @RequestParam String create_rol,
                               @RequestParam Integer create_estado){

        Usuarios usuario = new Usuarios();
        usuario.setUsername(create_username);
        usuario.setPassword(create_password);
        usuario.setEmail(create_email);
        usuario.setRol(create_rol);
        usuario.setEstado(create_estado);

        service.addUsuario(usuario);

        redirectAttributes.addFlashAttribute("exito", "Se añadió correctamente el usuario");
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/editar")
    public String editarUsuario(RedirectAttributes redirectAttributes,
                                @RequestParam Integer edit_codigo_usuario,
                                @RequestParam String edit_username,
                                @RequestParam String edit_password,
                                @RequestParam String edit_email,
                                @RequestParam String edit_rol,
                                @RequestParam Integer edit_estado){

        Usuarios usuario = new Usuarios();
        usuario.setCodigo_usuario(edit_codigo_usuario);
        usuario.setUsername(edit_username);
        usuario.setPassword(edit_password);
        usuario.setEmail(edit_email);
        usuario.setRol(edit_rol);
        usuario.setEstado(edit_estado);
        service.updateUsuario(usuario, edit_codigo_usuario);

        redirectAttributes.addFlashAttribute("exito", "Se editó correctamente el usuario");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteUsuario(id);
        redirectAttributes.addFlashAttribute("exito", "Se eliminó correctamente el usuario");
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/buscar")
    public String buscarUsuario(RedirectAttributes redirectAttributes,
                                @RequestParam Integer searched_id){
        Usuarios usuario = service.getUsuarioById(searched_id);
        redirectAttributes.addFlashAttribute("usuarios", List.of(usuario));
        redirectAttributes.addFlashAttribute("exito", "Se encontró el usuario");

        return "redirect:/usuarios";
    }
}

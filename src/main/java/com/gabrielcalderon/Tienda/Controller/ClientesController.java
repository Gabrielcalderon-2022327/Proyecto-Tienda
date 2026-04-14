package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import com.gabrielcalderon.Tienda.Service.ClientesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientesController {
    @Autowired
    private ClientesService service;

    @GetMapping("/clientes")
    public String cargarClientes(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("username"));
        return listarClientes(model);
    }

    @GetMapping("/listar")
    public String listarClientes(Model model){
        List<Clientes> clientes = service.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "Clientes";
    }
}

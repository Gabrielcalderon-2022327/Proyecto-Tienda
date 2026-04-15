package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import com.gabrielcalderon.Tienda.Service.ClientesService;
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
public class ClientesController {
    @Autowired
    private ClientesService service;

    @GetMapping("/clientes")
    public String cargarClientes(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("currentUser"));
        model.addAttribute("rol", session.getAttribute("rol"));
        if (!model.containsAttribute("clientes")) {
            model.addAttribute("clientes", service.getAllClientes());
        }
        return "Clientes";
    }

    @GetMapping("/clientes/listar")
    public String listarClientes(RedirectAttributes redirectAttributes){
        List<Clientes> clientes = service.getAllClientes();
        redirectAttributes.addFlashAttribute("clientes", service.getAllClientes());
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/crear")
    public String crearCliente(RedirectAttributes redirectAttributes,
                               @RequestParam String create_nombre_cliente,
                               @RequestParam String create_apellido_cliente,
                               @RequestParam String create_direccion,
                               @RequestParam Integer create_estado){
        Clientes cliente = new Clientes();
        cliente.setNombre_cliente(create_nombre_cliente);
        cliente.setApellido_cliente(create_apellido_cliente);
        cliente.setDireccion(create_direccion);
        cliente.setEstado(create_estado);
        service.addCliente(cliente);
        redirectAttributes.addFlashAttribute("exito", "Se añadio correctamente el cliente");
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/editar")
    public String editarClientes(RedirectAttributes redirectAttributes,
                                 @RequestParam Integer edit_dpi_cliente,
                                 @RequestParam String edit_nombre_cliente,
                                 @RequestParam String edit_apellido_cliente,
                                 @RequestParam String edit_direccion,
                                 @RequestParam Integer edit_estado){
        Clientes cliente = new Clientes();
        cliente.setNombre_cliente(edit_nombre_cliente);
        cliente.setApellido_cliente(edit_apellido_cliente);
        cliente.setDireccion(edit_direccion);
        cliente.setEstado(edit_estado);
        service.updateCliente(cliente, edit_dpi_cliente);
        redirectAttributes.addFlashAttribute("exito", "Se editó correctamente el cliente");
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteCliente(id);
        redirectAttributes.addFlashAttribute("exito", "Se eliminó correctamente el cliente");
        return "redirect:/clientes";
    }

    @PostMapping("/clientes/buscar")
    public String buscarClientes(RedirectAttributes redirectAttributes, @RequestParam Integer searched_id){
        Clientes cliente = service.getClienteById(searched_id);
        if(cliente == null){
            redirectAttributes.addFlashAttribute("error", "El cliente no existe");
            return "redirect:/clientes";
        }
        redirectAttributes.addFlashAttribute("clientes", List.of(cliente));
        redirectAttributes.addFlashAttribute("exito", "Se encontro el cliente");
        return "redirect:/clientes";
    }

}

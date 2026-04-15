package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Ventas;
import com.gabrielcalderon.Tienda.Service.VentasService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class VentasController {
    @Autowired
    private VentasService service;

    @GetMapping("/ventas")
    public String cargarClientes(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("currentUser"));
        model.addAttribute("rol", session.getAttribute("rol"));
        if (!model.containsAttribute("ventas")){
            model.addAttribute("ventas", service.getAllVentas());
        }
        return "Ventas";
    }

    @GetMapping("/ventas/listar")
    public String listarVentas(RedirectAttributes redirectAttributes){
        List<Ventas> ventas = service.getAllVentas();
        redirectAttributes.addFlashAttribute("ventas", ventas);
        return "redirect:/ventas";
    }

    @PostMapping("/ventas/crear")
    public String crearVentas(RedirectAttributes redirectAttributes,
                              @RequestParam LocalDate create_fecha_venta,
                              @RequestParam Double create_total,
                              @RequestParam Integer create_estado,
                              @RequestParam Integer create_clientes_dpi_cliente,
                              @RequestParam Integer create_usuarios_codigo_usuario
                              ){
        Ventas venta = new Ventas();
        venta.setFecha_venta(create_fecha_venta);
        venta.setTotal(create_total);
        venta.setEstado(create_estado);
        venta.setClientes_dpi_cliente(create_clientes_dpi_cliente);
        venta.setUsuarios_codigo_usuario(create_usuarios_codigo_usuario);
        service.addVenta(venta);
        redirectAttributes.addFlashAttribute("exito", "Se añadió correctamente la venta");
        return "redirect:/ventas";
    }

    @PostMapping("/ventas/editar")
    public String editarVentas(RedirectAttributes redirectAttributes,
                                @RequestParam Integer edit_codigo_venta,
                                @RequestParam LocalDate edit_fecha_venta,
                                @RequestParam Double edit_total,
                                @RequestParam Integer edit_estado,
                                @RequestParam Integer edit_clientes_dpi_cliente,
                                @RequestParam Integer edit_usuarios_codigo_usuario
                                ){
        Ventas venta = new Ventas();
        venta.setFecha_venta(edit_fecha_venta);
        venta.setTotal(edit_total);
        venta.setEstado(edit_estado);
        venta.setClientes_dpi_cliente(edit_clientes_dpi_cliente);
        venta.setUsuarios_codigo_usuario(edit_usuarios_codigo_usuario);
        service.updateVenta(venta, edit_codigo_venta);
        redirectAttributes.addFlashAttribute("exito", "Se editó correctamente la venta");
        return "redirect:/ventas";
    }

    @PostMapping("/ventas/buscar")
    public String buscarVentas(RedirectAttributes redirectAttributes, @RequestParam Integer searched_id){
        Ventas ventas = service.getVentaById(searched_id);
        if(ventas == null){
            redirectAttributes.addFlashAttribute("error", "La venta no existe");
            return "redirect:/ventas";
        }
        redirectAttributes.addFlashAttribute("ventas", List.of(ventas));
        redirectAttributes.addFlashAttribute("exito", "Se encontro la venta");
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/eliminar/{id}")
    public String eliminarVentas(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteVenta(id);
        redirectAttributes.addFlashAttribute("exito", "Se elimino la venta correctamente");
        return "redirect:/ventas";
    }
}

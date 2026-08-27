package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.DetalleVenta;
import com.gabrielcalderon.Tienda.Service.DetalleVentaService;
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
public class DetallesVentaController {
    @Autowired
    private DetalleVentaService service;

    @GetMapping("/detalles")
    public String cargarDetalles(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("currentUser"));
        model.addAttribute("rol", session.getAttribute("rol"));
        if (!model.containsAttribute("detalles")) {
            model.addAttribute("detalles", service.getAllDetallesVenta());
        }
        return "DetalleVenta";
    }

    @GetMapping("/detalles/listar")
    public String listarDetalles(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("detalles", service.getAllDetallesVenta());
        return "redirect:/detalles";
    }

    @PostMapping("/detalles/crear")
    public String crearDetalle(RedirectAttributes redirectAttributes,
                               @RequestParam Integer create_cantidad,
                               @RequestParam Double create_precio_unitario,
                               @RequestParam Double create_subtotal,
                               @RequestParam Integer create_productos_codigo_producto,
                               @RequestParam Integer create_ventas_codigo_venta){

        DetalleVenta detalle = new DetalleVenta();
        detalle.setCantidad(create_cantidad);
        detalle.setPrecio_unitario(create_precio_unitario);
        detalle.setSubtotal(create_subtotal);
        detalle.setProductos_codigo_producto(create_productos_codigo_producto);
        detalle.setVentas_codigo_venta(create_ventas_codigo_venta);

        service.addDetalleVenta(detalle);

        redirectAttributes.addFlashAttribute("exito", "Se añadió correctamente el detalle de venta");
        return "redirect:/detalles";
    }

    @PostMapping("/detalles/editar")
    public String editarDetalle(RedirectAttributes redirectAttributes,
                                @RequestParam Integer edit_codigo_detalle_venta,
                                @RequestParam Integer edit_cantidad,
                                @RequestParam Double edit_precio_unitario,
                                @RequestParam Double edit_subtotal,
                                @RequestParam Integer edit_productos_codigo_producto,
                                @RequestParam Integer edit_ventas_codigo_venta){

        DetalleVenta detalle = new DetalleVenta();
        detalle.setCodigo_detalle_venta(edit_codigo_detalle_venta);
        detalle.setCantidad(edit_cantidad);
        detalle.setPrecio_unitario(edit_precio_unitario);
        detalle.setSubtotal(edit_subtotal);
        detalle.setProductos_codigo_producto(edit_productos_codigo_producto);
        detalle.setVentas_codigo_venta(edit_ventas_codigo_venta);

        service.updateDetalleVenta(detalle, edit_codigo_detalle_venta);

        redirectAttributes.addFlashAttribute("exito", "Se editó correctamente el detalle de venta");
        return "redirect:/detalles";
    }

    @GetMapping("/detalles/eliminar/{id}")
    public String eliminarDetalle(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteDetalleVenta(id);
        redirectAttributes.addFlashAttribute("exito", "Se eliminó correctamente el detalle de venta");
        return "redirect:/detalles";
    }

    @PostMapping("/detalles/buscar")
    public String buscarDetalle(RedirectAttributes redirectAttributes,
                                @RequestParam Integer searched_id){
        DetalleVenta detalle = service.getDetalleVentaById(searched_id);
        redirectAttributes.addFlashAttribute("detalles", List.of(detalle));
        redirectAttributes.addFlashAttribute("exito", "Se encontró el detalle de venta");

        return "redirect:/detalles";
    }


}

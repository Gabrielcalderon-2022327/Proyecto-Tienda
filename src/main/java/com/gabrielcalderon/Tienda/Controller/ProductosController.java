package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Productos;
import com.gabrielcalderon.Tienda.Service.ProductosService;
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
public class ProductosController {
    @Autowired
    private ProductosService service;

    @GetMapping("/productos")
    public String cargarProductos(HttpSession session, Model model){
        if(session.getAttribute("currentUser") == null){
            return "redirect:/login";
        }
        model.addAttribute("username", session.getAttribute("currentUser"));
        model.addAttribute("rol", session.getAttribute("rol"));
        if (!model.containsAttribute("productos")){
            model.addAttribute("productos", service.getAllProductos());
        }
        return "Productos";
    }

    @GetMapping("/productos/listar")
    public String listarProductos(RedirectAttributes redirectAttributes){
        List<Productos> productos = service.getAllProductos();
        redirectAttributes.addFlashAttribute("productos", productos);
        return "redirect:/productos";
    }

    @PostMapping("/productos/crear")
    public String crearProductos(RedirectAttributes redirectAttributes,
                                 @RequestParam String create_nombre_producto,
                                 @RequestParam Double create_precio,
                                 @RequestParam Integer create_stock,
                                 @RequestParam Integer create_estado){

        Productos producto = new Productos();
        producto.setNombre_producto(create_nombre_producto);
        producto.setPrecio(create_precio);
        producto.setStock(create_stock);
        producto.setEstado(create_estado);
        service.addProducto(producto);
        redirectAttributes.addFlashAttribute("exito", "Se añadió correctamente el producto");
        return "redirect:/productos";
    }

    @PostMapping("/productos/editar")
    public String editarProductos(RedirectAttributes redirectAttributes,
                                  @RequestParam Integer edit_codigo_producto,
                                  @RequestParam String edit_nombre_producto,
                                  @RequestParam Double edit_precio,
                                  @RequestParam Integer edit_stock,
                                  @RequestParam Integer edit_estado){

        Productos producto = new Productos();
        producto.setNombre_producto(edit_nombre_producto);
        producto.setPrecio(edit_precio);
        producto.setStock(edit_stock);
        producto.setEstado(edit_estado);
        service.updateProducto(producto, edit_codigo_producto);
        redirectAttributes.addFlashAttribute("exito", "Se editó correctamente el producto");
        return "redirect:/productos";
    }

    @PostMapping("/productos/buscar")
    public String buscarProductos(RedirectAttributes redirectAttributes, @RequestParam Integer searched_id){
        Productos producto = service.getProductoById(searched_id);
        redirectAttributes.addFlashAttribute("productos", List.of(producto));
        redirectAttributes.addFlashAttribute("exito", "Se encontró el producto");
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProductos(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteProducto(id);
        redirectAttributes.addFlashAttribute("exito", "Se eliminó el producto correctamente");
        return "redirect:/productos";
    }
}

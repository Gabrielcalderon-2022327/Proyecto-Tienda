package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Productos;
import com.gabrielcalderon.Tienda.Service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    @Autowired
    private ProductosService service;

    @GetMapping
    public List<Productos> getAllProductos(){
        return service.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductoById(@PathVariable Integer id){
        Productos searchedProducto = service.getProductoById(id);
        return new ResponseEntity<>(searchedProducto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addProducto(@RequestBody @Valid Productos producto){
        Productos createdProducto = service.addProducto(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable Integer id, @RequestBody @Valid Productos producto){
        Productos updatedProducto = service.updateProducto(producto, id);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Integer id){
        service.deleteProducto(id);
        return new ResponseEntity<>("Se elimino el producto correctamente",HttpStatus.OK);
    }
}

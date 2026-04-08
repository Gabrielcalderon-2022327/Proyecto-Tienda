package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Ventas;
import com.gabrielcalderon.Tienda.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    @Autowired
    private VentasService service;

    @GetMapping
    public List<Ventas> getAllVentas(){
        return service.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVentaById(@PathVariable Integer id){
        Ventas searchedVenta = service.getVentaById(id);
        return new ResponseEntity<>(searchedVenta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addVenta(@RequestBody @Valid Ventas venta){
        Ventas createdVenta = service.addVenta(venta);
        return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable Integer id, @RequestBody @Valid Ventas venta){
        Ventas updatedVenta = service.updateVenta(venta, id);
        return new ResponseEntity<>(updatedVenta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVenta(@PathVariable Integer id){
        service.deleteVenta(id);
        return new ResponseEntity<>("Se elimino la venta correctamente",HttpStatus.OK);
    }
}

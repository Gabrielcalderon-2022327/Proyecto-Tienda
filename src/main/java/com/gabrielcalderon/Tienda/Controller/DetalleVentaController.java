package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.DetalleVenta;
import com.gabrielcalderon.Tienda.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles_venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService service;

    @GetMapping
    public List<DetalleVenta> getAllDetallesVenta(){
        return service.getAllDetallesVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetalleVentaById(@PathVariable Integer id){
        DetalleVenta searchedDetalleVenta = service.getDetalleVentaById(id);
        return new ResponseEntity<>(searchedDetalleVenta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addDetalleVenta(@RequestBody @Valid DetalleVenta detalleVenta){
        DetalleVenta createdDetalleVenta = service.addDetalleVenta(detalleVenta);
        return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetalleVenta(@PathVariable Integer id, @RequestBody @Valid DetalleVenta detalleVenta){
        DetalleVenta updatedDetalleVenta = service.updateDetalleVenta(detalleVenta, id);
        return new ResponseEntity<>(updatedDetalleVenta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetalleVenta(@PathVariable Integer id){
        service.deleteDetalleVenta(id);
        return new ResponseEntity<>("Se elimino el detalle de la venta correctamente",HttpStatus.OK);
    }

}

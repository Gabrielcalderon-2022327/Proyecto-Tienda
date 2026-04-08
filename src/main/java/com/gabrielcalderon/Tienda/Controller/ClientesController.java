package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import com.gabrielcalderon.Tienda.Service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    @Autowired
    private ClientesService service;

    @GetMapping
    public List<Clientes> getAllClientes(){
        return service.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Integer id){
        Clientes searchedCliente = service.getClienteById(id);
        return new ResponseEntity<>(searchedCliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addCliente(@RequestBody @Valid Clientes cliente){
        Clientes createdCliente = service.addCliente(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable Integer id, @RequestBody @Valid Clientes cliente){
        Clientes updatedCliente = service.updateCliente(cliente, id);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable Integer id){
        service.deleteCliente(id);
        return new ResponseEntity<>("Se elimino el cliente correctamente",HttpStatus.OK);
    }
}

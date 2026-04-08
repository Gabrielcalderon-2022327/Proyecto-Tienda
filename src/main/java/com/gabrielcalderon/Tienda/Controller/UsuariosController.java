package com.gabrielcalderon.Tienda.Controller;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import com.gabrielcalderon.Tienda.Service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService service;

    @GetMapping
    public List<Usuarios> getAllUsuarios(){
        return service.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable Integer id){
        Usuarios searchedUsuario = service.getUsuarioById(id);
        return new ResponseEntity<>(searchedUsuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addUsuario(@RequestBody @Valid Usuarios usuario){
        Usuarios createdUsuario = service.addUsuario(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Integer id, @RequestBody @Valid Usuarios usuario){
        Usuarios updatedUsuario = service.updateUsuario(usuario, id);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Integer id){
        service.deleteUsuario(id);
        return new ResponseEntity<>("Se elimino el usuario correctamente",HttpStatus.OK);
    }
}

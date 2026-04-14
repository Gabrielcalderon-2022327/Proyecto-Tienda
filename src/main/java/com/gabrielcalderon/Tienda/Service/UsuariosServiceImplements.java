package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import com.gabrielcalderon.Tienda.Exception.ResourceNotFoundException;
import com.gabrielcalderon.Tienda.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService{
    @Autowired
    private UsuariosRepository repository;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        Usuarios searchedUsuario = repository.findById(id).orElse(null);
        if (searchedUsuario == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        return searchedUsuario;
    }

    @Override
    public Usuarios addUsuario(Usuarios usuario) { //Añadir comprobacion para verificar usuario con findByUsername
        if (repository.findByUsername(usuario.getUsername()) != null){
            return null;
        }
        return repository.save(usuario);
    }

    @Override
    public Usuarios updateUsuario(Usuarios usuario, Integer id) { //Añadir comprobacion para verificar usuario con findByUsername
        Usuarios searchedUsuario = repository.findById(id).orElse(null);
        if (repository.findByUsername(usuario.getUsername()) != null){
            return null;
        }
        if (repository.findByEmail(usuario.getEmail()) != null){
            return null;
        }

        if (searchedUsuario == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        } else {
            searchedUsuario.setUsername(usuario.getUsername());
            searchedUsuario.setPassword(usuario.getPassword());
            searchedUsuario.setEmail(usuario.getEmail());
            searchedUsuario.setRol(usuario.getRol());
            searchedUsuario.setEstado(usuario.getEstado());
        }
        return repository.save(searchedUsuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        Usuarios searchedUsuario = repository.findById(id).orElse(null);
        if (searchedUsuario == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        repository.delete(searchedUsuario);
    }

    @Override
    public Usuarios login(String usuario, String password) {
        Usuarios user = repository.findByUsername(usuario);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

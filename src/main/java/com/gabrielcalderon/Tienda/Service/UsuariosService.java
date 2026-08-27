package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Integer id);
    Usuarios addUsuario(Usuarios usuario);
    Usuarios updateUsuario(Usuarios usuario, Integer id);
    void deleteUsuario(Integer id);
    Usuarios login(String usuario, String password);
}

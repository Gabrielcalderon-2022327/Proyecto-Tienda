package com.gabrielcalderon.Tienda.Repository;

import com.gabrielcalderon.Tienda.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByUsername(String username);
    Usuarios findByEmail(String email);
}

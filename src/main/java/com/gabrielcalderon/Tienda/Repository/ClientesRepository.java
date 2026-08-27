package com.gabrielcalderon.Tienda.Repository;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}

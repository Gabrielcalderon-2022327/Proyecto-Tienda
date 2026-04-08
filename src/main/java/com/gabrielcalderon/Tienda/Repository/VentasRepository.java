package com.gabrielcalderon.Tienda.Repository;

import com.gabrielcalderon.Tienda.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}

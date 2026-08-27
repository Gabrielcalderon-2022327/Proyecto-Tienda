package com.gabrielcalderon.Tienda.Repository;

import com.gabrielcalderon.Tienda.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}

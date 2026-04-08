package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentaById(Integer id);
    Ventas addVenta(Ventas venta);
    Ventas updateVenta(Ventas venta, Integer id);
    void deleteVenta(Integer id);
}

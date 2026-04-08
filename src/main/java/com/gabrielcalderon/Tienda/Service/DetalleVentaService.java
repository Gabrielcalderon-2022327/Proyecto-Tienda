package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAllDetallesVenta();
    DetalleVenta getDetalleVentaById(Integer id);
    DetalleVenta addDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta, Integer id);
    void deleteDetalleVenta(Integer id);
}
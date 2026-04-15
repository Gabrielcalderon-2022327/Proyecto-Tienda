package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.DetalleVenta;
import com.gabrielcalderon.Tienda.Exception.ResourceNotFoundException;
import com.gabrielcalderon.Tienda.Repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {
    @Autowired
    private DetalleVentaRepository repository;

    @Override
    public List<DetalleVenta> getAllDetallesVenta() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        DetalleVenta searchedDetalleVenta = repository.findById(id).orElse(null);
        if (searchedDetalleVenta == null){
            return null;
        }
        return searchedDetalleVenta;
    }

    @Override
    public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
        return repository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta, Integer id) {
        DetalleVenta searchedDetalleVenta = repository.findById(id).orElse(null);
        if (searchedDetalleVenta == null){
            return null;
        } else{
            searchedDetalleVenta.setCantidad(detalleVenta.getCantidad());
            searchedDetalleVenta.setPrecio_unitario(detalleVenta.getPrecio_unitario());
            searchedDetalleVenta.setSubtotal(detalleVenta.getSubtotal());
            searchedDetalleVenta.setProductos_codigo_producto(detalleVenta.getProductos_codigo_producto());
            searchedDetalleVenta.setVentas_codigo_venta(detalleVenta.getVentas_codigo_venta());
        }
        return repository.save(searchedDetalleVenta);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        DetalleVenta searchedDetalleVenta = repository.findById(id).orElse(null);
        if (searchedDetalleVenta == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        repository.delete(searchedDetalleVenta);
    }
}

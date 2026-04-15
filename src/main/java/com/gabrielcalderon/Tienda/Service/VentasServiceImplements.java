package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Ventas;
import com.gabrielcalderon.Tienda.Exception.ResourceNotFoundException;
import com.gabrielcalderon.Tienda.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    @Autowired
    private VentasRepository repository;

    @Override
    public List<Ventas> getAllVentas() {
        return repository.findAll();
    }

    @Override
    public Ventas getVentaById(Integer id) {
        Ventas searchedVenta =  repository.findById(id).orElse(null);
        if (searchedVenta == null){
            return null;
        }
        return searchedVenta;
    }

    @Override
    public Ventas addVenta(Ventas venta) {
        return repository.save(venta);
    }

    @Override
    public Ventas updateVenta(Ventas venta, Integer id) {
        Ventas searchedVenta =  repository.findById(id).orElse(null);
        if (searchedVenta == null){
            return null;
        } else{
            searchedVenta.setFecha_venta(venta.getFecha_venta());
            searchedVenta.setTotal(venta.getTotal());
            searchedVenta.setEstado(venta.getEstado());
            searchedVenta.setClientes_dpi_cliente(venta.getClientes_dpi_cliente());
            searchedVenta.setUsuarios_codigo_usuario(venta.getUsuarios_codigo_usuario());
        }
        return repository.save(searchedVenta);
    }

    @Override
    public void deleteVenta(Integer id) {
        Ventas searchedVenta =  repository.findById(id).orElse(null);
        if (searchedVenta == null){
            return;
        }
        repository.delete(searchedVenta);
    }


}

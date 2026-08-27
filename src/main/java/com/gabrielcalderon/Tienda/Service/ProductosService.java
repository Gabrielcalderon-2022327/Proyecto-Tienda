package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductoById(Integer id);
    Productos addProducto(Productos producto);
    Productos updateProducto(Productos producto, Integer id);
    void deleteProducto(Integer id);
}

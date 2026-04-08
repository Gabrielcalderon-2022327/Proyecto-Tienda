package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Productos;
import com.gabrielcalderon.Tienda.Exception.ResourceNotFoundException;
import com.gabrielcalderon.Tienda.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService{
    @Autowired
    private ProductosRepository repository;

    @Override
    public List<Productos> getAllProductos() {
        return repository.findAll();
    }

    @Override
    public Productos getProductoById(Integer id) {
        Productos searchedProducto = repository.findById(id).orElse(null);
        if (searchedProducto == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        return searchedProducto;
    }

    @Override
    public Productos addProducto(Productos producto) {
        return repository.save(producto);
    }

    @Override
    public Productos updateProducto(Productos producto, Integer id) {
        Productos searchedProducto = repository.findById(id).orElse(null);
        if (searchedProducto == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        } else {
            searchedProducto.setNombre_producto(producto.getNombre_producto());
            searchedProducto.setPrecio(producto.getPrecio());
            searchedProducto.setStock(producto.getStock());
            searchedProducto.setEstado(producto.getEstado());
        }
        return repository.save(searchedProducto);
    }

    @Override
    public void deleteProducto(Integer id) {
        Productos searchedProducto = repository.findById(id).orElse(null);
        if (searchedProducto == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        repository.delete(searchedProducto);
    }
}

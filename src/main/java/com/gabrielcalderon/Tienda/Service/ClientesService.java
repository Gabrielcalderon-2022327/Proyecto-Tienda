package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientesService {
    List<Clientes> getAllClientes();
    Clientes getClienteById(Integer id);
    Clientes addCliente(Clientes cliente);
    Clientes updateCliente(Clientes cliente, Integer id);
    void deleteCliente(Integer id);
}

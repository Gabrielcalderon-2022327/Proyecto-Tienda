package com.gabrielcalderon.Tienda.Service;

import com.gabrielcalderon.Tienda.Entity.Clientes;
import com.gabrielcalderon.Tienda.Exception.ResourceNotFoundException;
import com.gabrielcalderon.Tienda.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService{
    @Autowired
    private ClientesRepository repository;

    @Override
    public List<Clientes> getAllClientes() {
        return repository.findAll();
    }

    @Override
    public Clientes getClienteById(Integer id) {
        Clientes searchedCliente = repository.findById(id).orElse(null);
        if (searchedCliente == null){
            return null;
        }
        return searchedCliente;
    }

    @Override
    public Clientes addCliente(Clientes cliente) {
        return repository.save(cliente);
    }

    @Override
    public Clientes updateCliente(Clientes cliente, Integer id) {
        Clientes searchedCliente = repository.findById(id).orElse(null);
        if (searchedCliente == null){
            return null;
        } else{
            searchedCliente.setNombre_cliente(cliente.getNombre_cliente());
            searchedCliente.setApellido_cliente(cliente.getApellido_cliente());
            searchedCliente.setDireccion(cliente.getDireccion());
            searchedCliente.setEstado(cliente.getEstado());
        }
        return repository.save(searchedCliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        Clientes searchedCliente = repository.findById(id).orElse(null);
        if (searchedCliente == null){
            throw new ResourceNotFoundException("ID NO ENCONTRADO");
        }
        repository.delete(searchedCliente);
    }
}

package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Clientes;
import com.example.demo.Repositories.clienteRepository;

@Service
public class clienteService {

    @Autowired
    clienteRepository clientrepo;

    public List<Clientes> listaClientes() {

        List<Clientes> lista = clientrepo.findAll();

        return lista;
    }

    public Clientes clientesbyName(String nombres) {

        Clientes cliente = clientrepo.findByNombres(nombres);

        return cliente;
    }

    public Clientes clientesbyid(String id) {

        Clientes cliente = clientrepo.findByNumeroId(id);

        return cliente;
    }

    public Clientes SaveCliente(Clientes cliente) {
        return clientrepo.save(cliente);
    }

    public Clientes EditCliente(Clientes cliente) {

        return clientrepo.save(cliente);
    }

    public String DeleteCliente(Clientes cliente) {
        clientrepo.delete(cliente);
        return "Done";
    }
}
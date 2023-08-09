package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.Clientes;
import com.example.demo.Entities.DireccionCliente;
import com.example.demo.Repositories.direccionclienteRepository;

@Service
public class direccionclienteService {

    @Autowired
    direccionclienteRepository direccionrepo;

    public List<DireccionCliente> direccionClientes() {

        List<DireccionCliente> lista = direccionrepo.findAll();

        return lista;
    }

    public List<DireccionCliente> direccionbyclient(Clientes cliente) {

        List<DireccionCliente> direcciones = direccionrepo.findByClient(cliente);

        return direcciones;
    }

    public DireccionCliente DireccionMatrizbyClient(Clientes cliente, boolean matriz) {

        DireccionCliente direcionMatriz = direccionrepo.findByDireccionMatriz(cliente, matriz);

        return direcionMatriz;
    }

    public DireccionCliente SaveDireccionCliente(DireccionCliente direccionC) {
        return direccionrepo.save(direccionC);
    }

    public DireccionCliente EditDireccionCliente(DireccionCliente direccionC) {

        return direccionrepo.save(direccionC);
    }

    public String DeleteDireccionCliente(DireccionCliente direccionC) {
        direccionrepo.delete(direccionC);
        return "Done";
    }
}
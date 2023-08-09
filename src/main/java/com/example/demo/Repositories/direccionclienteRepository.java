package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Clientes;
import com.example.demo.Entities.DireccionCliente;

public interface direccionclienteRepository extends JpaRepository<DireccionCliente, Integer> {

    List<DireccionCliente> findAll();

    List<DireccionCliente> findByClient(Clientes idCliente);

    DireccionCliente findByDireccionMatriz(Clientes idCliente, boolean matriz);
}
package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Clientes;

public interface clienteRepository extends JpaRepository<Clientes, Integer> {
    Clientes findByNombres(String nombres);

    List<Clientes> findAll();

    Clientes findByNumeroId(String numeroId);
}
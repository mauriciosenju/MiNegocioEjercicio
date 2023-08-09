package com.example.demo.Entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ClientesTest {

    @Test
    void test() {
        Clientes cliente = new Clientes(1, "josefo@hotmail.com", "jose Fortune", "09854555", "0985456666", "cedula");

        assertEquals("jose Fortune", cliente.getNombres());
        assertEquals("0985456666", cliente.getNumeroId());
        assertNotNull(cliente.getId());

    }

}

package com.example.demo.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DireccionClienteTest {
    @Test
    void test() {
        DireccionCliente direccion = new DireccionCliente(1, "guayas", "Guayaquil",
                "ciudadela nueve de octubre mz 2 solar 34 ");

        assertEquals("Guayaquil", direccion.getCiudad());
        assertEquals(1, direccion.getId());

    }
}

package com.example.demo.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo.Entities.DireccionCliente;
import com.example.demo.Repositories.direccionclienteRepository;

public class direccionclienteServiceTest {

    @InjectMocks
    private direccionclienteService direccionservice;
    @Mock
    private direccionclienteRepository direccionrepo;

    private DireccionCliente direccion;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        direccion = new DireccionCliente(1, "Guayas", "Guayaquil", "ciudadela nueve de octubre mz 2 solar 34", true);
    }

    @Test
    void testSaveDireccionCliente() {
 when(direccionrepo.save(any())).thenReturn(direccion);
      assertNotNull(direccionrepo.save(any()));
      assertEquals("Guayaquil", direccion.getCiudad());
        assertEquals(1, direccion.getId());
    }

    @Test
    void testDireccionbyclient() {
  when(direccionrepo.findByClient(any())).thenReturn( Arrays.asList(direccion));
      assertNotNull(direccionservice.direccionbyclient(any()));
      
    }
}

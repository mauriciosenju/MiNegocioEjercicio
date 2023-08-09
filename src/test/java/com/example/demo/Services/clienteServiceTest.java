package com.example.demo.Services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo.Entities.Clientes;
import com.example.demo.Repositories.clienteRepository;

public class clienteServiceTest {

  @InjectMocks
  private clienteService clienteservice;
  @Mock
  private clienteRepository clientrepo;

  private Clientes cliente;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    cliente = new Clientes(1, "josefo@hotmail.com", "jose Fortune", "09854555", "0985456666", "cedula");
  }

  @Test
  void testSaveCliente() {
 when(clientrepo.save(any())).thenReturn(cliente);
      assertNotNull(clientrepo.save(any()));
    
  }

  @Test
    void testListaClientes() {
      when(clientrepo.findAll()).thenReturn( Arrays.asList(cliente));
      assertNotNull(clienteservice.listaClientes());
      
    }

  @Test
  void testDeleteCliente() {
    when(clienteservice.DeleteCliente(any())).thenReturn("Done");
      assertNotNull(clienteservice.DeleteCliente(any()));
    
  }

  @Test
  void testEditCliente() {
 when(clientrepo.save(any())).thenReturn(cliente);
      assertNotNull(clientrepo.save(any()));
    
  }

}

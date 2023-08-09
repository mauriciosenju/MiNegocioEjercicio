package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entities.Clientes;
import com.example.demo.Entities.DireccionCliente;
import com.example.demo.Services.clienteService;
import com.example.demo.Services.direccionclienteService;
import com.example.demo.Util.clienteyDireccion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class minegocioController {

    @Autowired
    clienteService clientesService;
    @Autowired
    direccionclienteService direccionCliente;

    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clientes>> allClientes() {

        log.info("Inside clientes  of minegocioController");
        return ResponseEntity.ok(clientesService.listaClientes());
    }

    // Cedula o RUC
    @GetMapping(value = "/cliente/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findClientebyCedula(@PathVariable("cedula") String cedula) {
        log.info("Inside cliente  of minegocioController");
        HashMap<String, Object> data = new HashMap<String, Object>();
        Clientes cliente = clientesService.clientesbyid(cedula);
        List<DireccionCliente> lista = (List<DireccionCliente>) cliente.getDireccionClienteCollection();
        for (DireccionCliente direccion : lista) {
            if (direccion.getMatriz()) {
                data.put("Matriz", direccion);
            }
        }
        JSONObject result = new JSONObject(data);
        return new ResponseEntity<JSONObject>(result, HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/addcliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clientes> addCliente(@RequestBody clienteyDireccion data) {
        log.info("Inside addcliente  of minegocioController");
        Clientes cliente = data.clientes;
        DireccionCliente direccion = data.direccionCliente;
        Clientes result = clientesService.SaveCliente(cliente);
        direccion.setIdCliente(result);
        direccionCliente.SaveDireccionCliente(direccion);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/editcliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clientes> editCliente(@RequestBody Clientes cliente) {
        Clientes result = clientesService.EditCliente(cliente);
        log.info("Inside editcliente  of minegocioController");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/deletecliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteClientes(@RequestBody Clientes cliente) {
        String result = clientesService.DeleteCliente(cliente);
        log.info("Inside deletecliente  of minegocioController");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/direccionesbyclient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DireccionCliente>> allDireccionesbyClient(@RequestBody Clientes cliente) {
        log.info("Inside direccionesbyclient  of minegocioController");
        return ResponseEntity.ok(direccionCliente.direccionbyclient(cliente));
    }

    @PostMapping(value = "/addDireccion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DireccionCliente> addDireccion(@RequestBody clienteyDireccion data) {
        Clientes cliente = data.clientes;
        DireccionCliente direccion = data.direccionCliente;
        direccion.setIdCliente(cliente);
        DireccionCliente result = direccionCliente.SaveDireccionCliente(direccion);
        log.info("Inside addDireccion  of minegocioController");
        return ResponseEntity.ok(result);
    }
}

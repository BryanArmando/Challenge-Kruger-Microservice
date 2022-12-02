package com.micro.cliente.controllers;

import com.micro.cliente.entity.Cliente;
import com.micro.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public List<Cliente> listar(){ return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Cliente> clienteOptional = service.porId(id);
        if(clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cliente));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id){
        Optional<Cliente> o = service.porId(id);
        if(o.isPresent()) {
            Cliente usuarioDb = o.get();
            usuarioDb.setNombre(cliente.getNombre());
            usuarioDb.setEmail(cliente.getEmail());
            usuarioDb.setPassword(cliente.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Cliente> o = service.porId(id);
        if(o.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

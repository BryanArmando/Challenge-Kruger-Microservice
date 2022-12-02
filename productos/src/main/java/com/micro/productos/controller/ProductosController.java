package com.micro.productos.controller;

import com.micro.productos.entity.Productos;
import com.micro.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<List<Productos>> obtenerproductos(){
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        Optional<Productos> prod =productoService.buscarId(id);
        if (prod.isPresent()){
            return ResponseEntity.ok(prod.get());
        }
        return ResponseEntity.notFound().build();
    }
}

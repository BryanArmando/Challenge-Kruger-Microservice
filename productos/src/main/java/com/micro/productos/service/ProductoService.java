package com.micro.productos.service;

import com.micro.productos.entity.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Productos> listar();

    Optional<Productos> buscarId(Integer id);

}

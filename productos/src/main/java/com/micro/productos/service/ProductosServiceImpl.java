package com.micro.productos.service;

import com.micro.productos.entity.Productos;
import com.micro.productos.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProductosServiceImpl implements ProductoService{
    @Autowired
    private ProductosRepository productosRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Productos> listar() {
        return productosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> buscarId(Integer id) {
        return productosRepository.findById(id);
    }
}

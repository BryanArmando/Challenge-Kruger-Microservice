package com.micro.productos.repository;

import com.micro.productos.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}

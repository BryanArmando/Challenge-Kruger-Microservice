package com.micro.productos.repository;

import com.micro.productos.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}

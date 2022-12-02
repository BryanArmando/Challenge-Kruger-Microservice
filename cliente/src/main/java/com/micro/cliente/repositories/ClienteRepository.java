package com.micro.cliente.repositories;

import com.micro.cliente.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {


}

package com.micro.cliente.services;

import com.micro.cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();

    Optional<Cliente> porId(Long id);

    Cliente guardar(Cliente cliente);

    void eliminar(Long id);


}

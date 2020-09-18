package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ClienteEntity;

public interface ClienteRepository {
    void crearCliente(ClienteEntity cliente);
    void comprobarCliente(ClienteEntity cliente);
}

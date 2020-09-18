package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ClienteEntity;
import com.hotel.java.conection.Conection;

import java.util.List;

public interface ClienteRepository {
    void newCliente(ClienteEntity cliente);
    List<ClienteEntity> listarClientes();
    ClienteEntity listarClienteById(long id);
    void deleteCliente(ClienteEntity clienteEntity);
    void updateCliente(ClienteEntity clienteEntity) ;
}

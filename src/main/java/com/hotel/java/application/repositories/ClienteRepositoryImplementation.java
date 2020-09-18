package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ClienteEntity;
import com.hotel.java.conection.Conection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClienteRepositoryImplementation implements ClienteRepository {

    @Autowired
    public ClienteRepositoryImplementation(SessionFactory dbConnection) {
        Conection.conectar(dbConnection);
    }

    @Override
    public void newCliente(ClienteEntity cliente) {
        Conection.crudObjeto(cliente, true);
    }

    @Override
    public List<ClienteEntity> listarClientes() {
        return (List<ClienteEntity>)(List<?>) Conection.findAll (ClienteEntity.class);
    }

    @Override
    public ClienteEntity listarClienteById(long id) {
        return (ClienteEntity) Conection.findById (ClienteEntity.class, id);
    }

    @Override
    public void deleteCliente(ClienteEntity clienteEntity) {
        Conection.crudObjeto (clienteEntity, false);
    }

    @Override
    public void updateCliente(ClienteEntity clienteEntity) {
        Conection.crudObjeto (clienteEntity, true);
    }
}
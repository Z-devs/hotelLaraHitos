package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ClienteEntity;
import com.hotel.java.conection.Conection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImplementation implements ClienteRepository {

    @Autowired
    public ClienteRepositoryImplementation(SessionFactory dbConnection) {
        Conection.conectar(dbConnection);
    }

    @Override
    public void crearCliente(ClienteEntity cliente) {
        Conection.crudObjeto(cliente, true);
    }

    @Override
    public void comprobarCliente(ClienteEntity cliente) {

    }
}

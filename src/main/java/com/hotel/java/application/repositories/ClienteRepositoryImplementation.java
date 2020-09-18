package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ClienteEntity;
import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.conection.Conection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public class ClienteRepositoryImplementation implements ClienteRepository {
    private Transaction transaction = null;
    private Session session;
    private static CriteriaBuilder cb;
    private static SessionFactory dbConnection;

    @Autowired
    public ClienteRepositoryImplementation(SessionFactory dbConnection) {
        this.dbConnection = Conection.conectar(dbConnection);
    }

    @Override
    public void crearCliente(ClienteEntity cliente) {
        Conection.crearObjeto(cliente);
    }

    @Override
    public void comprobarCliente(ClienteEntity cliente) {

    }
}

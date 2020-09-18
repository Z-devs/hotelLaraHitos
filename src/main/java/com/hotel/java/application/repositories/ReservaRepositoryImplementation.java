package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.*;
import com.hotel.java.conection.Conection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ReservaRepositoryImplementation implements ReservaRepository{
    private Transaction transaction = null;
    private Session session;
    private static CriteriaBuilder cb;
    private static SessionFactory dbConnection;

    @Autowired
    public ReservaRepositoryImplementation(SessionFactory dbConnection) {
        Conection.conectar(dbConnection);
    }

    @Override
    public List<ReservaEntity> listarReservas() {
        List<ReservaEntity> lista = (List<ReservaEntity>)(List<?>) Conection.findAll (ReservaEntity.class);
        return lista;
    }

    @Override
    public ReservaEntity listarReservaById(long id) {
        ReservaEntity reservaEntity = null;
        session = dbConnection.openSession ();
        try{
            reservaEntity = session.get(ReservaEntity.class, id);
        }catch (Throwable ex) {
            ex.printStackTrace ();
        }
        finally {
            session.close();
        }
        return reservaEntity;
    }

    @Override
    public void newReserva(ReservaEntity reservaEntity) {
        Conection.crudObjeto (reservaEntity, true);
    }

    @Override
    public void deleteReserva(ReservaEntity reservaEntity) {
        Conection.crudObjeto (reservaEntity, false);
    }

    @Override
    public void updateReserva(ReservaEntity reservaEntity) {
        Conection.crudObjeto (reservaEntity, true);
    }

}

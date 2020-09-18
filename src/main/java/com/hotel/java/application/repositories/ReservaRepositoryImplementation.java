package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservaRepositoryImplementation implements ReservaRepository{
    private Transaction transaction = null;
    private Session session;
    private static CriteriaBuilder cb;
    private static SessionFactory dbConnection;

    @Autowired
    public ReservaRepositoryImplementation(SessionFactory dbConnection) {
        try{
            this.dbConnection = dbConnection;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace ();
            System.out.println ("______________________________________________________________");
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public List<ReservaEntity> listarReservas() {
        List<ReservaEntity> reservaEntities = new ArrayList<> ();
        session = dbConnection.openSession ();
        cb = session.getCriteriaBuilder();
        try {
            //reservaEntities = session.createQuery("FROM ReservaEntity ", ReservaEntity.class).getResultList();
            CriteriaQuery<ReservaEntity> q = cb.createQuery (ReservaEntity.class);
            q.select (q.from (ReservaEntity.class));
            reservaEntities = session.createQuery (q).getResultList ();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return reservaEntities;
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
        session = dbConnection.openSession();
        try {
            transaction = session.beginTransaction();
            session.save (reservaEntity);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteReserva(ReservaEntity reservaEntity) {
        session = dbConnection.openSession();
        try{
            transaction = session.beginTransaction ();
            session.delete (reservaEntity);
            transaction.commit ();
        }catch (Throwable ex){
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void updateReserva(ReservaEntity reservaEntity) {
        session = dbConnection.openSession();
        try {
            transaction = session.beginTransaction();
            session.update (reservaEntity);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

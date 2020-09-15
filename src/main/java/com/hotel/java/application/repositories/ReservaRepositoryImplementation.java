package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entitiesHB.ReservaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReservaRepositoryImplementation implements ReservaRepository{
    private Transaction transaction = null;
    private Session session;
    private static SessionFactory dbConnection;

    //Constructor
    public ReservaRepositoryImplementation() {
        try{
            Configuration config = new Configuration();
            config.addAnnotatedClass(ReservaEntity.class);
            config.configure();
            dbConnection = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public List<ReservaEntity> listarReservas() {
        List<ReservaEntity> reservaEntities = null;
        session = dbConnection.openSession ();
        try {
            reservaEntities = session.createQuery("FROM ReservaEntity", ReservaEntity.class).getResultList();
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

        return null;
    }

    @Override
    public void newReserva(ReservaEntity reservaEntity) {

    }

    @Override
    public void deleteReserva(ReservaEntity reservaEntity) {

    }

    @Override
    public void updateReserva(ReservaEntity reservaEntity) {

    }
}

package com.hotel.java.conection;

import com.hotel.java.application.domain.entities.ReservaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class Conection {
    private static SessionFactory dbConnection;
    private static Transaction transaction = null;
    private static Session session;
    private static CriteriaBuilder cb;


    public static void conectar(SessionFactory dbConnection) {
        try{
            setDbConnection (dbConnection);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace ();
            System.out.println ("______________________________________________________________");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void setDbConnection(SessionFactory dbConnection) {
        Conection.dbConnection = dbConnection;
    }

    public static void crudObjeto (Object object, boolean saveOrUpdate){
        session = dbConnection.openSession();
        try {
            transaction = session.beginTransaction();
            if (saveOrUpdate)
                session.saveOrUpdate (object);
            else
                session.delete (object);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static List<Object> findAll(Class classEntity){
        List<Object> objects = new ArrayList<> ();
        session = dbConnection.openSession ();
        cb = session.getCriteriaBuilder();
        try {
            CriteriaQuery<Object> q = cb.createQuery (classEntity);
            q.select (q.from (classEntity));
            objects = session.createQuery (q).getResultList ();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return objects;
    }
}

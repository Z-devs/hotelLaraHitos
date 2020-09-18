package com.hotel.java.conection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Conection {
    private static SessionFactory dbConnection;
    private static Transaction transaction = null;
    private static Session session;

    public static SessionFactory conectar(SessionFactory dbConnection) {
        setDbConnection (dbConnection);
        try{
            return dbConnection;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            ex.printStackTrace ();
            System.out.println ("______________________________________________________________");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void crearObjeto (Object object){
        session = dbConnection.openSession();
        try {
            transaction = session.beginTransaction();
            session.save (object);
            transaction.commit();
        } catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static void setDbConnection(SessionFactory dbConnection) {
        Conection.dbConnection = dbConnection;
    }
}

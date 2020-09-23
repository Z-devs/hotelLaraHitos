package com.hotel.java.application.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MasterRepositoryImplementation implements MasterRepository{
    Session session;
    Transaction transaction;
    SessionFactory dbConnection;
    private static CriteriaBuilder cb;

    @Autowired
    public MasterRepositoryImplementation (SessionFactory dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void newObject(Object object, boolean saveOrUpdate) {
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

    @Override
    public List<Object> listarTodo(Class classEntity) {
        List<Object> objects = new ArrayList<> ();
        session = dbConnection.openSession ();
        cb = session.getCriteriaBuilder();
        try {
            CriteriaQuery<Object> q = cb.createQuery (classEntity);
            q.select (q.from (classEntity));
            objects = session.createQuery (q).getResultList ();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return objects;
    }

    @Override
    public Object listarById(long id, Class classEntity) {
        Object object = null;
        session = dbConnection.openSession ();
        try{
            object = session.get(classEntity, id);
        }catch (Throwable ex) {
            ex.printStackTrace ();
        }
        finally {
            session.close();
        }
        return object;
    }
}

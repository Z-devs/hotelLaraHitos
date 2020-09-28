package com.hotel.java.application.repositories;

import java.util.List;

public interface MasterRepository {
    void newObject(Object object, boolean saveOrUpdate);
    List<Object> listarTodo(Class classEntity);
    Object listarById(long id, Class classEntity);
    List<Object> listCampoGT(Class classEntity, int valor, String campo);
    List<Object> listCampoLT(Class classEntity, int valor, String campo);
    long newSignUp(Object object);
    List<Object> showByType(Class classEntity, String campo);
}

package com.hotel.java.application.repositories;

import java.util.List;

public interface MasterRepository {
    void newObject(Object object, boolean saveOrUpdate);
    List<Object> listarTodo(Class classEntity);
    Object listarById(long id, Class classEntity);
}

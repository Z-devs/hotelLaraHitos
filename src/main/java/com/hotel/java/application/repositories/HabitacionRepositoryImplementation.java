package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.HabitacionEntity;
import com.hotel.java.conection.Conection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HabitacionRepositoryImplementation implements HabitacionRepository {
    @Autowired
    public HabitacionRepositoryImplementation(SessionFactory dbConnection) {
        Conection.conectar(dbConnection);
    }

    @Override
    public void newReserva(HabitacionEntity habitacionEntity) {
        Conection.crudObjeto (habitacionEntity, true);
    }

    @Override
    public List<HabitacionEntity> listarHabitaciones() {
        return (List<HabitacionEntity>)(List<?>) Conection.findAll (HabitacionEntity.class);
    }

    @Override
    public HabitacionEntity listarHabitacionById(long id) {
        return (HabitacionEntity) Conection.findById (HabitacionEntity.class, id);
    }

    @Override
    public void deleteHabitacion(HabitacionEntity habitacionEntity) {
        Conection.crudObjeto (habitacionEntity, false);
    }

    @Override
    public void updateHabitacion(HabitacionEntity habitacionEntity) {
        Conection.crudObjeto (habitacionEntity, true);
    }

}

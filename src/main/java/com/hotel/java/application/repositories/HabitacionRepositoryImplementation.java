package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.HabitacionEntity;
import com.hotel.java.conection.Conection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HabitacionRepositoryImplementation implements HabitacionRepository {
    Conection function;
    @Autowired
    public HabitacionRepositoryImplementation(SessionFactory dbConnection) {
        function = new Conection ();
        function.conectar(dbConnection);
    }

    @Override
    public void newReserva(HabitacionEntity habitacionEntity) {
        function.crudObjeto (habitacionEntity, true);
    }

    @Override
    public List<HabitacionEntity> listarHabitaciones() {
        return (List<HabitacionEntity>)(List<?>) function.findAll (HabitacionEntity.class);
    }

    @Override
    public HabitacionEntity listarHabitacionById(long id) {
        return (HabitacionEntity) function.findById (HabitacionEntity.class, id);
    }

    @Override
    public void deleteHabitacion(HabitacionEntity habitacionEntity) {
        function.crudObjeto (habitacionEntity, false);
    }

    @Override
    public void updateHabitacion(HabitacionEntity habitacionEntity) {
        function.crudObjeto (habitacionEntity, true);
    }

}

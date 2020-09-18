package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.*;
import com.hotel.java.conection.Conection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservaRepositoryImplementation implements ReservaRepository{
    Conection function;
    @Autowired
    public ReservaRepositoryImplementation(SessionFactory dbConnection) {
        function = new Conection ();
        function.conectar(dbConnection);
    }

    @Override
    public void newReserva(ReservaEntity reservaEntity) {
        function.crudObjeto (reservaEntity, true);
    }

    @Override
    public List<ReservaEntity> listarReservas() {
        return (List<ReservaEntity>)(List<?>) function.findAll (ReservaEntity.class);
    }

    @Override
    public ReservaEntity listarReservaById(long id) {
        return (ReservaEntity) function.findById (ReservaEntity.class, id);
    }

    @Override
    public void deleteReserva(ReservaEntity reservaEntity) {
        function.crudObjeto (reservaEntity, false);
    }

    @Override
    public void updateReserva(ReservaEntity reservaEntity) {
        function.crudObjeto (reservaEntity, true);
    }
}
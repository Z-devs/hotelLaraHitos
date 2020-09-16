package com.hotel.java.application.domain.factories;



import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.application.models.ReservaModel;

import java.util.ArrayList;
import java.util.List;

public class ReservaFactory {
    ClienteFactory clienteFactory = new ClienteFactory ();
    HabitacionFactory habitacionFactory = new HabitacionFactory ();


    public ReservaEntity reservaModel2Entity (ReservaModel reservaModel){
        ReservaEntity reservaEntity =
                new ReservaEntity (
                        reservaModel.getId (),
                        reservaModel.getFechaIn (),
                        reservaModel.getFechaOut (),
                        reservaModel.getPrecioTotal (),
                        clienteFactory.clienteModel2Entity (reservaModel.getClienteModel ()),
                        habitacionFactory.habitacionModel2Entity (reservaModel.getHabitacionModel ())
                        );
        return reservaEntity;
    }

    public ReservaModel reservaEntity2Model (ReservaEntity reservaEntity){
        ReservaModel reservaModel =
                new ReservaModel (
                        reservaEntity.getId (),
                        reservaEntity.getFechaIn (),
                        reservaEntity.getFechaOut (),
                        reservaEntity.getPrecioTotal (),
                        clienteFactory.clienteEntity2Model (reservaEntity.getClienteEntity ()),
                        habitacionFactory.habitacionEntity2Model (reservaEntity.getHabitacionEntity ())
                );
        return reservaModel;
    }

    /*public List<ReservaEntity> reservaListModel2Entity  (List<ReservaModel> reservaModels){
        List<ReservaEntity> reservaEntities = new ArrayList<> ();
        for (ReservaModel reserva : reservaModels){
            ReservaEntity reservaEntity =
                    new ReservaEntity (
                            reserva.getNombre (),
                            reserva.getApellido (),
                            reserva.getEmail ()
                    );
        }
        return reservaEntities;
    }*/

    public List<ReservaModel> reservaListEntity2Model(List<ReservaEntity> reservaEntities){
        List<ReservaModel> reservaModels = new ArrayList<> ();
        for (ReservaEntity reserva : reservaEntities){
            ReservaModel reservaModel =
                    new ReservaModel (
                            reserva.getId (),
                            reserva.getFechaIn (),
                            reserva.getFechaOut (),
                            reserva.getPrecioTotal (),
                            clienteFactory.clienteEntity2Model (reserva.getClienteEntity ()),
                            habitacionFactory.habitacionEntity2Model(reserva.getHabitacionEntity ())
                    );
        }
        return reservaModels;
    }
}

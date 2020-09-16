package com.hotel.java.application.domain.factories;


import com.hotel.java.application.domain.entities.HabitacionEntity;
import com.hotel.java.application.models.HabitacionModel;

public class HabitacionFactory {
    TipoFactory tipoFactory;

    public HabitacionEntity habitacionModel2Entity (HabitacionModel habitacionModel){
        HabitacionEntity habitacionEntity =
                new HabitacionEntity (
                        habitacionModel.getId (),
                        habitacionModel.getCodigo (),
                        habitacionModel.getDescripcion (),
                        habitacionModel.getPrecio (),
                        tipoFactory.tipoModel2Entity(habitacionModel.getTipoModel ())
                );
        return habitacionEntity;
    }
}

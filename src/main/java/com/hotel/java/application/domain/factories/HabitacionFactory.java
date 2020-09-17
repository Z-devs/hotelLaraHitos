package com.hotel.java.application.domain.factories;


import com.hotel.java.application.domain.entities.HabitacionEntity;
import com.hotel.java.application.models.HabitacionModel;
import org.springframework.stereotype.Component;

@Component
public class HabitacionFactory {
    TipoFactory tipoFactory = new TipoFactory ();

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

    public HabitacionModel habitacionEntity2Model (HabitacionEntity habitacionEntity){
        HabitacionModel habitacionModel =
                new HabitacionModel (
                        habitacionEntity.getId (),
                        habitacionEntity.getCodigo (),
                        habitacionEntity.getDescripcion (),
                        habitacionEntity.getPrecio (),
                        tipoFactory.tipoEntity2Model(habitacionEntity.getTipo ())
                );
        return habitacionModel;
    }

}

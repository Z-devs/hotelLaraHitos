package com.hotel.java.application.services;

import com.hotel.java.application.domain.entities.HabitacionEntity;
//import com.hotel.java.application.domain.factories.ClienteFactory;
import com.hotel.java.application.domain.factories.HabitacionFactory;
//import com.hotel.java.application.domain.factories.ReservaFactory;
import com.hotel.java.application.models.HabitacionModel;
import com.hotel.java.application.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImplementation implements HabitacionService{
    private final MasterRepository masterRepository;
    private final HabitacionFactory habitacionFactory ;
    private List<HabitacionEntity> habitacionEntities;
    private List<HabitacionModel> habitacionModels;

    @Autowired
    public HabitacionServiceImplementation(MasterRepository masterRepository,

                                        HabitacionFactory habitacionFactory) {
        this.masterRepository = masterRepository;
        this.habitacionFactory = habitacionFactory;
    }

    @Override
    public List<HabitacionModel> showAllHabitaciones() {
        habitacionEntities = (List<HabitacionEntity>)(List<?>)this.masterRepository.listarTodo (HabitacionEntity.class);
        habitacionModels = this.habitacionFactory.habitacionListEntity2Model(habitacionEntities);
        return habitacionModels;
    }

    @Override
    public List<HabitacionModel> showHabitacionesByGuest(int numGuest) {
        habitacionEntities = (List<HabitacionEntity>)(List<?>)this.masterRepository.listCampoGT (HabitacionEntity.class, numGuest, "numpersonas");
        habitacionModels = this.habitacionFactory.habitacionListEntity2Model(habitacionEntities);
        return habitacionModels;
    }
}

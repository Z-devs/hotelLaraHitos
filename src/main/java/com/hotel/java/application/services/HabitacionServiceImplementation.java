package com.hotel.java.application.services;

import com.hotel.java.application.domain.entities.HabitacionEntity;
import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.application.domain.factories.ClienteFactory;
import com.hotel.java.application.domain.factories.HabitacionFactory;
import com.hotel.java.application.domain.factories.ReservaFactory;
import com.hotel.java.application.models.HabitacionModel;
import com.hotel.java.application.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImplementation implements HabitacionService{
    private MasterRepository masterRepository;
    private ReservaFactory reservaFactory;
    private ClienteFactory clienteFactory;
    private HabitacionFactory habitacionFactory ;

    @Autowired
    public HabitacionServiceImplementation(MasterRepository masterRepository,
                                        ReservaFactory reservaFactory,
                                        ClienteFactory clienteFactory,
                                        HabitacionFactory habitacionFactory) {
        this.masterRepository = masterRepository;
        this.reservaFactory = reservaFactory;
        this.clienteFactory = clienteFactory;
        this.habitacionFactory = habitacionFactory;
    }

    @Override
    public List<HabitacionModel> showHabitacionesByGuest(int numGuest) {
        List<HabitacionEntity> habitacionEntities = (List<HabitacionEntity>)(List<?>)this.masterRepository.listCampoGT (HabitacionEntity.class, numGuest, "numpersonas");
        List<HabitacionModel> habitacionModels = this.habitacionFactory.habitacionListEntity2Model(habitacionEntities);
        return habitacionModels;
    }
}

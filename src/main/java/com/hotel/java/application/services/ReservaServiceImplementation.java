package com.hotel.java.application.services;

import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.application.domain.factories.ClienteFactory;
import com.hotel.java.application.domain.factories.HabitacionFactory;
import com.hotel.java.application.domain.factories.ReservaFactory;
import com.hotel.java.application.models.ReservaModel;
import com.hotel.java.application.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImplementation implements ReservaService {
    private MasterRepository masterRepository;
    private ReservaFactory reservaFactory;
    private ClienteFactory clienteFactory;
    private HabitacionFactory habitacionFactory ;

    @Autowired
    public ReservaServiceImplementation(MasterRepository masterRepository,
                                        ReservaFactory reservaFactory,
                                        ClienteFactory clienteFactory,
                                        HabitacionFactory habitacionFactory) {
        this.masterRepository = masterRepository;
        this.reservaFactory = reservaFactory;
        this.clienteFactory = clienteFactory;
        this.habitacionFactory = habitacionFactory;
    }

    @Override
    public List<ReservaModel> listReservas() {
        List<ReservaEntity> reservaEntities = (List<ReservaEntity>)(List<?>)this.masterRepository.listarTodo (ReservaEntity.class);
        List<ReservaModel> reservaModels = this.reservaFactory.reservaListEntity2Model(reservaEntities);
        return reservaModels;
    }

    @Override
    public ReservaModel listReservaById(long id) {
        ReservaEntity reservaEntity = (ReservaEntity) this.masterRepository.listarById (id, ReservaEntity.class);
        ReservaModel reservaModel = this.reservaFactory.reservaEntity2Model (reservaEntity);
        return reservaModel;
    }

    @Override
    public void operateReserva(ReservaModel reservaModel, String modo) {
        ReservaEntity reservaEntity = new ReservaEntity (
            reservaModel.getId (),
                reservaModel.getFechaIn (),
                reservaModel.getFechaOut (),
                reservaModel.getPrecioTotal (),
                this.clienteFactory.clienteModel2Entity (reservaModel.getCliente ()),
                this.habitacionFactory.habitacionModel2Entity (reservaModel.getHabitacion ())
        );
        switch (modo){
            case "new": this.masterRepository.newObject (reservaEntity, true);
            case "delete": this.masterRepository.newObject (reservaEntity, false);
            case "update": this.masterRepository.newObject (reservaEntity, true);
            default: System.out.println (
                    "Error de modo: ReservaImplementation -> operateReserva -> variable \"modo\" mal pasada"
                    );
        }
    }
}

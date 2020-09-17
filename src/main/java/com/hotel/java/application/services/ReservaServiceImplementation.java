package com.hotel.java.application.services;

import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.application.domain.factories.ClienteFactory;
import com.hotel.java.application.domain.factories.HabitacionFactory;
import com.hotel.java.application.domain.factories.ReservaFactory;
import com.hotel.java.application.models.ReservaModel;
import com.hotel.java.application.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImplementation implements ReservaService {
    private ReservaRepository reservaRepository;
    private ReservaFactory reservaFactory;
    private ClienteFactory clienteFactory;
    private HabitacionFactory habitacionFactory ;

    @Autowired
    public ReservaServiceImplementation(ReservaRepository reservaRepository,
                                        ReservaFactory reservaFactory,
                                        ClienteFactory clienteFactory,
                                        HabitacionFactory habitacionFactory) {
        this.reservaRepository = reservaRepository;
        this.reservaFactory = reservaFactory;
        this.clienteFactory = clienteFactory;
        this.habitacionFactory = habitacionFactory;
    }

    @Override
    public List<ReservaModel> listReservas() {
        List<ReservaEntity> reservaEntities = this.reservaRepository.listarReservas ();
        List<ReservaModel> reservaModels = this.reservaFactory.reservaListEntity2Model(reservaEntities);
        return reservaModels;
    }

    @Override
    public ReservaModel listReservaById(long id) {
        ReservaEntity reservaEntity = this.reservaRepository.listarReservaById (id);
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
                this.clienteFactory.clienteModel2Entity (reservaModel.getClienteModel ()),
                this.habitacionFactory.habitacionModel2Entity (reservaModel.getHabitacionModel ())
        );
        if (modo.equals ("new"))
            this.reservaRepository.newReserva (reservaEntity);
        if (modo.equals ("delete"))
            this.reservaRepository.deleteReserva (reservaEntity);
        if (modo.equals ("update"))
            this.reservaRepository.updateReserva (reservaEntity);

    }
/*
    @Override
    public void deleteReserva(ReservaModel reservaModel) {
        ReservaEntity reservaEntity = new ReservaEntity (
                reservaModel.getId (),
                reservaModel.getFechaIn (),
                reservaModel.getFechaOut (),
                reservaModel.getPrecioTotal (),
                this.clienteFactory.clienteModel2Entity (reservaModel.getClienteModel ()),
                this.habitacionFactory.habitacionModel2Entity (reservaModel.getHabitacionModel ())
        );
        this.reservaRepository.deleteReserva (reservaEntity);
    }

    @Override
    public void updateReserva(ReservaModel reservaModel) {
        ReservaEntity reservaEntity = new ReservaEntity (
                reservaModel.getId (),
                reservaModel.getFechaIn (),
                reservaModel.getFechaOut (),
                reservaModel.getPrecioTotal (),
                this.clienteFactory.clienteModel2Entity (reservaModel.getClienteModel ()),
                this.habitacionFactory.habitacionModel2Entity (reservaModel.getHabitacionModel ())
        );
        this.reservaRepository.updateReserva (reservaEntity);
    }*/
}

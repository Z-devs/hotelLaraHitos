package com.hotel.java.application.services;

import com.hotel.java.application.domain.entities.ReservaEntity;
import com.hotel.java.application.domain.factories.ReservaFactory;
import com.hotel.java.application.models.ReservaModel;
import com.hotel.java.application.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservaServiceImplementation implements ReservaService {
    private ReservaRepository reservaRepository;
    private ReservaFactory reservaFactory = new ReservaFactory ();

    @Autowired
    public ReservaServiceImplementation(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
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
    public void newReserva(ReservaModel reservaModel) {

    }

    @Override
    public void deleteReserva(ReservaModel reservaModel) {

    }

    @Override
    public void updateReserva(ReservaModel reservaModel) {

    }
}

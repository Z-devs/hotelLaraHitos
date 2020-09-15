package com.hotel.java.application.services;

import com.hotel.java.application.models.ReservaModel;

import java.util.List;

public interface ReservaService {
    List<ReservaModel> listarReservas();
    ReservaModel listarReservaById(long id);
    void newReserva(ReservaModel reservaModel);
    void deleteReserva(ReservaModel reservaModel);
    void updateReserva(ReservaModel reservaModel);
}

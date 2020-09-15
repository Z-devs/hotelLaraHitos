package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.ReservaEntity;

import java.util.List;

public interface ReservaRepository {
    List<ReservaEntity> listarReservas();
    ReservaEntity listarReservaById(long id);
    void newReserva(ReservaEntity reservaEntity);
    void deleteReserva(ReservaEntity reservaEntity);
    void updateReserva(ReservaEntity reservaEntity);
}

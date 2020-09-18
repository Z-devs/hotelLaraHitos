package com.hotel.java.application.repositories;

import com.hotel.java.application.domain.entities.HabitacionEntity;

import java.util.List;

public interface HabitacionRepository {
    void newReserva(HabitacionEntity habitacionEntity);

    List<HabitacionEntity> listarHabitaciones();

    HabitacionEntity listarHabitacionById(long id);

    void deleteHabitacion(HabitacionEntity habitacionEntity);

    void updateHabitacion(HabitacionEntity habitacionEntity);
}

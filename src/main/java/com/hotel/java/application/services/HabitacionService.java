package com.hotel.java.application.services;

import com.hotel.java.application.models.HabitacionModel;

import java.util.List;

public interface HabitacionService {
    List<HabitacionModel> showHabitacionesByGuest(int numGuest);
}

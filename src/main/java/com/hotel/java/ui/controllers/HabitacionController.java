package com.hotel.java.ui.controllers;

import com.hotel.java.application.models.HabitacionModel;
import com.hotel.java.application.services.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/listRooms")
public class HabitacionController {
    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/")
    public ModelAndView showAll() {
        List<HabitacionModel> habitaciones = habitacionService.showAllHabitaciones();
        for (HabitacionModel up: habitaciones){
            System.out.println(up.getTipoModel());
        }
        ModelAndView model = new ModelAndView ("habitaciones");
        model.addObject ("habitaciones", habitaciones);
        return model;
    }

    @GetMapping("/showByGuest/{numguest}")
    public ModelAndView showbByGuest(@PathVariable("numguest") Integer numguest) {
        List<HabitacionModel> habitaciones = habitacionService.showHabitacionesByGuest (numguest);
        ModelAndView model = new ModelAndView ("habitacion");
        model.addObject ("habitacion", habitaciones);
        return model;
    }
}

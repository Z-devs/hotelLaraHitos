package com.hotel.java.ui.controllers;

import com.hotel.java.application.services.HabitacionService;
import com.hotel.java.application.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/showByGuest/{numguest}")
    public ModelAndView login(@PathVariable("numguest") Integer numguest) {
        ModelAndView model = new ModelAndView ();
        model.addObject (habitacionService.showHabitacionesByGuest (numguest));
        return new ModelAndView ("login");

    }
}

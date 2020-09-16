package com.hotel.java.ui.controllers;

import com.hotel.java.application.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reservas")
public class ReservaController {


    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {

        this.reservaService = reservaService;
    }

}

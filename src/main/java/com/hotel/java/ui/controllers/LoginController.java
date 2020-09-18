package com.hotel.java.ui.controllers;

import com.hotel.java.application.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class LoginController {
    private final ReservaService reservaService;

    public LoginController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("login")
    public Model login(Model model) {

        return model;

    }

    @GetMapping("protected")
    public Model resource(Model model) {

        this.reservaService.listReservas ();

        return model;

    }
}

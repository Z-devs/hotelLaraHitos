package com.hotel.java.ui.controllers;

import com.hotel.java.application.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

public class LoginController {
    private final ReservaService reservaService;

    public LoginController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("login")
    public ModelAndView login() {

        return new ModelAndView ("login2");

    }

    @GetMapping("protected")
    public Model resource(Model model) {

        this.reservaService.listReservas ();

        return model;

    }
}

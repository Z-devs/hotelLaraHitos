package com.hotel.java.ui.controllers;

import com.hotel.java.application.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

public class LoginController {

    @GetMapping("/loginMain")
    public ModelAndView login() {

        return new ModelAndView ("login");

    }

    @GetMapping("index")
    public ModelAndView index() {

        return new ModelAndView ("index");

    }
}

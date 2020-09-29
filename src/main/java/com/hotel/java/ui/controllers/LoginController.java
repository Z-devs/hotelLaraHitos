package com.hotel.java.ui.controllers;

import com.hotel.java.application.models.ClienteModel;
import com.hotel.java.application.models.HabitacionModel;
import com.hotel.java.application.models.LoginModel;
import com.hotel.java.application.dto.SignupFormModel;
import com.hotel.java.application.services.ClienteService;
import com.hotel.java.application.services.HabitacionService;
import com.hotel.java.application.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")

public class LoginController {

    private final ClienteService clienteService;
    private final LoginService loginService;
    private final HabitacionService habitacionService;

    @Autowired
    public LoginController(ClienteService client, LoginService loginService, HabitacionService habitacionService) {
        this.clienteService = client;
        this.loginService = loginService;
        this.habitacionService = habitacionService;
    }

    @GetMapping("loginMain")
    public ModelAndView login() {
        return new ModelAndView ("login");
    }

    @PostMapping("newUser")
    public String submit(@Valid @ModelAttribute("signUP") SignupFormModel signupFormModel){
        ClienteModel cliente = new ClienteModel (signupFormModel.getNombre (), signupFormModel.getApellido (), signupFormModel.getEmail ());
        long res = clienteService.createCliente (cliente);
        cliente.setId (res);
        LoginModel login = new LoginModel (signupFormModel.getNewUsername (), signupFormModel.getNewPassword (), "ROLE_USER", true, cliente);
        loginService.createLogin(login);
        return "redirect:/loginMain?q=Registrado+Correctamente!";
    }

    @GetMapping("index")
    public ModelAndView index() {
        List<HabitacionModel> habitacionesPorTipo = this.habitacionService.showHabitacionesByTipo();
        System.out.println (habitacionesPorTipo);
        ModelAndView model = new ModelAndView ("habitaciones");
        model.addObject ("habitaciones", habitacionesPorTipo);
        return new ModelAndView ("index");
    }
}

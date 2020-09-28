package com.hotel.java.ui.controllers;

import com.hotel.java.application.models.ClienteModel;
import com.hotel.java.application.models.LoginModel;
import com.hotel.java.application.dto.SignupFormModel;
import com.hotel.java.application.services.ClienteService;
import com.hotel.java.application.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")

public class LoginController {

    private final ClienteService clienteService;
    private final LoginService loginService;

    @Autowired
    public LoginController(ClienteService client, LoginService loginService) {
        this.clienteService = client;
        this.loginService = loginService;
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
        return new ModelAndView ("index");
    }
}

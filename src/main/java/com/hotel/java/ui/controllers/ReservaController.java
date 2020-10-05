package com.hotel.java.ui.controllers;

import com.hotel.java.application.models.ReservaModel;
import com.hotel.java.application.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView("reservas");
        return mav;
    }


    @GetMapping("showall")
    public ModelAndView viewList(){
        List<ReservaModel> reservas = reservaService.listReservas ();
        ModelAndView mav = new ModelAndView("reservas");
        mav.addObject("reservas", reservas);
        return mav;
    }

    @GetMapping("newReserva")
    public void newReserva(@Valid @ModelAttribute("reserva") ReservaModel reservaModel) {
        this.reservaService.operateReserva (reservaModel, "new");
    }

}

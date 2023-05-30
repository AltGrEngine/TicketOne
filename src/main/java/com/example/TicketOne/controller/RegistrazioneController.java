package com.example.TicketOne.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TicketOne.service.UtenteService;

@Controller
public class RegistrazioneController {

    @Autowired
    private UtenteService utService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(@RequestParam Map<String, String> params){

        utService.addProfilo(params);

        return "login.html";
    }

    

}

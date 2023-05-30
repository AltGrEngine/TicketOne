package com.ticketone.progettoTicketOne.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrazioneController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(@RequestParam Map<String, String> params){
        return "login.html";
    }


}

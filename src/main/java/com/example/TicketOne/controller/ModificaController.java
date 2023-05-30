package com.example.TicketOne.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TicketOne.service.UtenteService;

@Controller
public class ModificaController {

    @Autowired
    private UtenteService uService;
    
    @RequestMapping(path = "/modificaDati", method = RequestMethod.GET)
    public String modUtente(@RequestParam Map<String, String> params){
        uService.modUtente(params);
        return "redirect:/areaRiservata?username=" + params.get("username");
    }

}

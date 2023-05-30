package com.example.TicketOne.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.TicketOne.database.UtentiDAO;
import com.example.TicketOne.models.Utente;

@Controller
public class ProfiliController {

    @Autowired
    private UtentiDAO pDao;

    public String checkUser(Map<String, String> params) {
        String ris = "KO";
		String username = params.get("username");
		String password = params.get("password");
        Utente p = pDao.readUser(username);
        if (p != null) {
            
            ris = "Pw sbagliata";

            if(p.getPassword().equals(password)) {
				
                ris = "OK";
            }
            else{
                //Pass sbagliata
            }
        }
        else{
            //Username Sbagliato
        }

		return ris;
	}


}

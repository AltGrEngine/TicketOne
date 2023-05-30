package com.example.TicketOne.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.TicketOne.database.ProfiliDAO;
import com.example.TicketOne.models.Profilo;

@Controller
public class ProfiliController {

    @Autowired
    private ProfiliDAO pDao;

    public String checkUser(Map<String, String> params) {
        String ris = "KO";
		String username = params.get("username");
		String password = params.get("pass");
        Profilo p = pDao.readUser(username);
        if (p != null) {
            
            ris = "Pw sbagliata";

            if(p.getPass().equals(password)) {
				
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

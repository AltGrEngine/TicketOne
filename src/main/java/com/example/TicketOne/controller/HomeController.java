package com.ticketone.TicketOne.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ProfiliController proController;
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		
/* 		if(session.getAttribute("username")!=null) {
			session.invalidate();
		} */
		
		return "index.html";
	}

    @RequestMapping(path = "/loginUtente", method = RequestMethod.GET)
	public String login(@RequestParam Map<String, String> params, Model model) {
		
		String ris = "Username sbagliato";
		
		String user = params.get("username");
		String pw = params.get("pass");
		
		String check = proController.checkUser(params);
		
		if("OK".equals(check)) {
			model.addAttribute("username", user);
			model.addAttribute("pass", pw);
			model.addAttribute("check", check);
			ris = "redirect:/areaRiservata?username=" + user;
			
		} else {
			model.addAttribute("errore", "Username o Password non corretti");
			ris = "redirect:/";
		}
		
	    return ris;
	}

    @RequestMapping(path = "/registrazione", method = RequestMethod.GET)
    public String registrazione(Model model){
        return "registrazione.html";
    }

    @RequestMapping(path = "/areaRiservata", method = RequestMethod.GET)
    public String areaRiservata(Model model){
        return "areaRiservata.html";
    }


}

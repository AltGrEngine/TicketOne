package com.example.TicketOne.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TicketOne.database.UtentiDAO;
import com.example.TicketOne.models.Utente;
import com.example.TicketOne.service.UtenteService;

@Controller
public class HomeController {

    @Autowired
    private UtentiController utController;

	@Autowired
	private UtentiDAO uDao;

	@Autowired
	private UtenteService utService;
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {

		if(session.getAttribute("username")!=null) {
			session.invalidate();
		}

		return "index.html";
	}

    @RequestMapping(path = "/loginUtente", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> params, HttpSession session) {
		
		String ris = "Username sbagliato";
		
		String user = params.get("username");
		String pw = params.get("password");
		
		String check = utController.checkUser(params);
		
		if("OK".equals(check)) {
			session.setAttribute("username", user);
			session.setAttribute("password", pw);
			session.setAttribute("check", check);
			ris = "redirect:/areaRiservata?username=" + user;
			
		} else {
			session.setAttribute("errore", "Username o Password non corretti");
			ris = "redirect:/";
		}
		
	    return ris;
	}

    @RequestMapping(path = "/registrazione", method = RequestMethod.GET)
    public String registrazione(Model model){
        return "registrazione.html";
    }

    @RequestMapping(path = "/areaRiservata", method = RequestMethod.GET)
    public String areaRiservata(@RequestParam Map<String, String> params, HttpSession session){

		String username = params.get("username");
		Utente u = getUtenteUser(username);

		session.setAttribute("utente", u);

        return "areaRiservata.html";
    }
	
	public Utente getUtenteUser(String username) {
		Utente c = uDao.readUser(username);
		if(c == null) {
			return null;
		} else {
			utService.getUtente(c.getId());
			return c;
		}
	}
	

}

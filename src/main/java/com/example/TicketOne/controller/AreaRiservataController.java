package com.example.TicketOne.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AreaRiservataController {

    @RequestMapping(path = "/modDati", method = RequestMethod.GET)
	public String modDati(HttpSession session) {
		return "modificaDati.html";
	}

}

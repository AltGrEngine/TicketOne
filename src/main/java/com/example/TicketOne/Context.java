package com.example.TicketOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.TicketOne.service.BigliettiService;
import com.example.TicketOne.service.EventoService;
import com.example.TicketOne.service.GenereService;
import com.example.TicketOne.service.LocalitaService;
import com.example.TicketOne.service.LuogoService;
import com.example.TicketOne.service.UtenteService;

@Configuration
public class Context {

	@Bean
	public UtenteService proService(){
		return new UtenteService();
	}

	@Bean
	public LuogoService lService() {
		return new LuogoService();
	}

	@Bean
	public LocalitaService locService() {
		return new LocalitaService();
	}

	@Bean
	public GenereService gService() {
		return new GenereService();
	}
	
	@Bean
	public EventoService eService() {
		return new EventoService();
	}

	@Bean
	public BigliettiService BigliettiService() {
		return new BigliettiService();
	}
	
}

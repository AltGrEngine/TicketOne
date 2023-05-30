package com.ticketone.progettoTicketOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ticketone.progettoTicketOne.service.BigliettiService;
import com.ticketone.progettoTicketOne.service.EventoService;
import com.ticketone.progettoTicketOne.service.GenereService;
import com.ticketone.progettoTicketOne.service.LocalitaService;
import com.ticketone.progettoTicketOne.service.LuogoService;
import com.ticketone.progettoTicketOne.service.ProfiloService;

@Configuration
public class Context {

	@Bean
	public ProfiloService proService(){
		return new ProfiloService();
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
	/* @Bean
	public ClientiService cliService() {
		return new ClientiService();
	}
	
	@Bean
	public ContiService conService() {
		return new ContiService();
	}
	
	@Bean
	public TransazioniService transService() {
		return new TransazioniService();
	}
	
	@Bean
	public DipendentiService dipService() {
		return new DipendentiService();
	} */
}

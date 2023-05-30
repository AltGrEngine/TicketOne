package com.ticketone.progettoTicketOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ticketone.progettoTicketOne.database.BigliettiDAO;
import com.ticketone.progettoTicketOne.database.Database;
import com.ticketone.progettoTicketOne.database.EventoDAO;
import com.ticketone.progettoTicketOne.database.GenereDAO;
import com.ticketone.progettoTicketOne.database.LocalitaDAO;
import com.ticketone.progettoTicketOne.database.LuoghiDAO;
import com.ticketone.progettoTicketOne.database.ProfiliDAO;
import com.ticketone.progettoTicketOne.database.SpettacoliDAO;

@Configuration
public class DatabaseContext {
	
	@Bean
	public Database db() {
		return new Database("Progettone");
	}

	@Bean
	public ProfiliDAO profiliDao() {
		return new ProfiliDAO();
	}

	@Bean
	public LuoghiDAO luoghiDao() {
		return new LuoghiDAO();
	}

	@Bean
	public LocalitaDAO localitaDao() {
		return new LocalitaDAO();
	}

	@Bean
	public GenereDAO gDao() {
		return new GenereDAO();
	}

	@Bean
	public EventoDAO eDao() {
		return new EventoDAO();
	}

	@Bean
	public BigliettiDAO bDao() {
		return new BigliettiDAO();
	}

	@Bean
	public SpettacoliDAO sDao() {
		return new SpettacoliDAO();
	}
	/* 
	@Bean
	public ClientiDAO clientiDao() {
		return new ClientiDAO();
	}
	
	@Bean
	public ContiDAO contiDao() {
		return new ContiDAO();
	}
	
	@Bean
	public TransazioniDAO tranDao() {
		return new TransazioniDAO();
	}
	
	@Bean
	public DipendentiDAO dipDao() {
		return new DipendentiDAO();
	} */
	
}

package com.example.TicketOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.TicketOne.database.BigliettiDAO;
import com.example.TicketOne.database.Database;
import com.example.TicketOne.database.EventoDAO;
import com.example.TicketOne.database.GenereDAO;
import com.example.TicketOne.database.LocalitaDAO;
import com.example.TicketOne.database.LuoghiDAO;
import com.example.TicketOne.database.UtentiDAO;

@Configuration
public class DatabaseContext {
	
	@Bean
	public Database db() {
		return new Database("ticketone");
	}

	@Bean
	public UtentiDAO profiliDao() {
		return new UtentiDAO();
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
	
}

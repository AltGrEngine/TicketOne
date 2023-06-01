package com.example.TicketOne;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.TicketOne.models.Evento;
import com.example.TicketOne.models.Utente;

@Configuration
public class ModelContext {

	@Bean
	@Scope("prototype")
	public Utente newProfilo(Map<String, String> params){
		Utente u = (Utente) new Utente().fromMap(params);
		return u;
	}

	@Bean
	@Scope("prototype")
	public Evento newEvento(Map<String, String> params){
		Evento e = (Evento) new Evento().fromMap(params);
		return e;
	}
}

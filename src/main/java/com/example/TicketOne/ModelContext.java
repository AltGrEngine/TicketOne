package com.ticketone.progettoTicketOne;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.ticketone.progettoTicketOne.models.Profilo;

@Configuration
public class ModelContext {

	@Bean
	@Scope("prototype")
	public Profilo newProfilo(Map<String, String> params){
		return (Profilo) new Profilo().fromMap(params);
	}


	/* @Bean
	@Scope("prototype")
	public Cliente newCliente(Map<String, String> params) {
		return (Cliente) new Cliente().fromMap(params);
	}
	
	@Bean
	@Scope("prototype")
	public Conto newConto(Map<String, String> params) {
		
		return (Conto) new Conto().fromMap(params);
	}
	
	@Bean
	@Scope("prototype")
	public Transazione newTransazione(Map<String, String> params) {
		return (Transazione) new Transazione().fromMap(params);
	}
	
	@Bean
	@Scope("prototype")
	public Dipendente newDip(Map<String, String> params) {
		return (Dipendente) new Dipendente().fromMap(params);
	} */
	
	
}

package com.ticketone.progettoTicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.database.EventoDAO;
import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Evento;

public class EventoService {

    @Autowired
    private EventoDAO eDao;

    public List<Evento> getEvento(){
		List<Evento> listEventi = new ArrayList<Evento>();
		
		for(Entity c : eDao.read().values())
			listEventi.add((Evento) c);
		
		return listEventi;
	}

    public Evento getEvento(int id){
        return eDao.readOne(id);
    }
}

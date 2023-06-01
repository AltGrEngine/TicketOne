package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.EventoDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Evento;

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

    public List<Evento> getEventoByTitolo(){
		List<Evento> listEventi = new ArrayList<Evento>();
		
		for(Entity c : eDao.readByTitolo().values())
			listEventi.add((Evento) c);
		
		return listEventi;
	}
}

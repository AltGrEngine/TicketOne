package com.ticketone.progettoTicketOne.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Evento;

public class EventoDAO implements IDAO {

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        return false;
    }

    @Override
	public Map<Integer, Entity> read() {
		String query = "select * from eventi";
		
		Map<Integer, Entity> ris = new HashMap<Integer, Entity>();
		for(Entry<Integer, Map<String, String>> obj : db.executeQuery(query).entrySet()) {
			ris.put(obj.getKey(), context.getBean(Evento.class, obj.getValue()));
		}
		return ris;
	}

    public Evento readOne(int id){
        String query = "select * from eventi where id = ?";
        return context.getBean(Evento.class, db.executeQuery(query, id+"").get(id));
    }

    @Override
    public boolean update(Entity e) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    
}

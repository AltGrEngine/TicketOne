package com.example.TicketOne.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Spettacoli;

public class SpettacoliDAO implements IDAO{

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
		String query = "select * from spettacoli";
		
		Map<Integer, Entity> ris = new HashMap<Integer, Entity>();
		for(Entry<Integer, Map<String, String>> obj : db.executeQuery(query).entrySet()) {
			ris.put(obj.getKey(), context.getBean(Spettacoli.class, obj.getValue()));
		}
		return ris;
	}

    public Spettacoli readOne(int id){
        String query = "select * from spettacoli where id = ?";
        return context.getBean(Spettacoli.class, db.executeQuery(query, id+"").get(id));
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

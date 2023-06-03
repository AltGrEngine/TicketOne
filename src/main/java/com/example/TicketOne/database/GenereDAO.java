package com.example.TicketOne.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Genere;

public class GenereDAO implements IDAO {

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
		String query = "select * from generi";
		
		Map<Integer, Entity> ris = new HashMap<Integer, Entity>();
		for(Entry<Integer, Map<String, String>> obj : db.executeQuery(query).entrySet()) {
			ris.put(obj.getKey(), context.getBean(Genere.class, obj.getValue()));
		}
		return ris;
	}

    public Genere readOne(int id){
        String query = "select * from generi where id = ?";
        return context.getBean(Genere.class, db.executeQuery(query, id+"").get(id));
    }

    public Genere readOneGenere(String genere){
        String query = "select * from generi where genere = ?";
        return context.getBean(Genere.class, db.executeQuery(query, genere));
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

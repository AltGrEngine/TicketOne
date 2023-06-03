package com.example.TicketOne.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Luogo;

public class LuoghiDAO implements IDAO {

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
		String query = "select * from luoghi";
		
		Map<Integer, Entity> ris = new HashMap<Integer, Entity>();
		for(Entry<Integer, Map<String, String>> obj : db.executeQuery(query).entrySet()) {
			ris.put(obj.getKey(), context.getBean(Luogo.class, obj.getValue()));
		}
		return ris;
	}

    public Luogo readOne(int id){
        String query = "select * from luoghi where id = ?";
        return context.getBean(Luogo.class, db.executeQuery(query, id+"").get(id));
    }

    public Luogo readOneLuogo(int idcitta){
        String query = "select * from luoghi where idcitta = ?";
        return context.getBean(Luogo.class, db.executeQuery(query, idcitta+"").get(idcitta));
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

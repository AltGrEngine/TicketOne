package com.ticketone.progettoTicketOne.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ticketone.progettoTicketOne.models.Biglietti;
import com.ticketone.progettoTicketOne.models.Entity;

public class BigliettiDAO implements IDAO{

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into biglietti(tipologia,prezzo,id_profili,id_data_evento) values(?,?,?,?)";
        return db.executeUpdate(query, ((Biglietti) e).getTipologia(), ((Biglietti) e).getPrezzo()+"", ((Biglietti) e).getId_profili()+"", ((Biglietti) e).getId_data_evento()+"");
    }


    @Override
	public Map<Integer, Entity> read() {
		String query = "select * from biglietti";
		
		Map<Integer, Entity> ris = new HashMap<Integer, Entity>();
		for(Entry<Integer, Map<String, String>> obj : db.executeQuery(query).entrySet()) {
			ris.put(obj.getKey(), context.getBean(Biglietti.class, obj.getValue()));
		}
		return ris;
	}

    public Biglietti readOne(int id){
        String query = "select * from biglietti where id = ?";
        return context.getBean(Biglietti.class, db.executeQuery(query, id+"").get(id));
    }

	@Override
	public boolean update(Entity e) {
		String query = "update biglietti set id_data_evento = ? where id = ?";
		return db.executeUpdate(query, ((Biglietti) e).getId_data_evento()+"");
	}

	@Override
	public boolean delete(int id) {
		String query = "delete from biglietti where id = ?";
		return db.executeUpdate(query, id+"");
	}
}

package com.ticketone.progettoTicketOne.database;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Profilo;

public class ProfiliDAO implements IDAO{

    @Autowired
    private Database db;

	@Autowired
	private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into profili(nome,cognome,email,datanascita,username,pass) values(?,?,?,?,?,?)";
        return db.executeUpdate(query, ((Profilo) e).getNome(), ((Profilo) e).getCognome(), ((Profilo) e).getEmail(), ((Profilo) e).getDatanascita()+"", ((Profilo) e).getUsername(), ((Profilo) e).getPass());
    }

    public Profilo readOne(int id){
        String query = "select * from profili where id = ?";
        return context.getBean(Profilo.class, db.executeQuery(query, id+"").get(id));
    }

    public Profilo readUser(String username){
        String query = "select * from profili where username = ?";
        Profilo pNelDao = context.getBean(Profilo.class, db.executeQuery(query, username));
        return pNelDao;
    }

    @Override
    public Map<Integer, Entity> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Entity e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}

package com.example.TicketOne.database;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Utente;

public class ProfiliDAO implements IDAO{

    @Autowired
    private Database db;

	@Autowired
	private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into utenti(nome,cognome,data_nascita,email,luogo_nascita,username,password) values(?,?,?,?,?,?,?)";
        return db.executeUpdate(query, ((Utente) e).getNome(), ((Utente) e).getCognome(), ((Utente) e).getEmail(), ((Utente) e).getDatanascita()+"", ((Utente) e).getUsername(), ((Utente) e).getPassword());
    }

    public Utente readOne(int id){
        String query = "select * from utenti where id = ?";
        return context.getBean(Utente.class, db.executeQuery(query, id+"").get(id));
    }

    public Utente readUser(String username){
        String query = "select * from utenti where username = ?";
        Utente pNelDao = context.getBean(Utente.class, db.executeQuery(query, username));
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

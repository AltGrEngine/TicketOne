package com.example.TicketOne.database;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Utente;

public class UtentiDAO implements IDAO{

    @Autowired
    private Database db;

	@Autowired
	private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into utenti(nome,cognome,dataNascita,email,luogoNascita,username,password) values(?,?,?,?,?,?,?)";
        return db.executeUpdate(query, 
        ((Utente) e).getNome(), 
        ((Utente) e).getCognome(), 
        ((Utente) e).getDataNascita()+"", 
        ((Utente) e).getEmail(), 
        ((Utente) e).getLuogoNascita(), 
        ((Utente) e).getUsername(), 
        ((Utente) e).getPassword());
    }

    public Utente readOne(int id){
        String query = "select * from utenti where id = ?";
        return context.getBean(Utente.class, db.executeQuery(query, id+"").get(id));
    }

    public Utente readUser(String username){
        String query = "select * from utenti where username = ?";
        for (Entry<Integer, Map<String, String>> entry : db.executeQuery(query, username).entrySet()) {
            return context.getBean(Utente.class, entry.getValue());
        }
        return null;
    }

    @Override
    public Map<Integer, Entity> read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Entity e) {
        String query = "update utenti set nome = ?, cognome =?, dataNascita =?, email =?, luogoNascita =?, username =?, password =? where id = ?";
        return db.executeUpdate(query, 
        ((Utente) e).getNome(), 
        ((Utente) e).getCognome(), 
        ((Utente) e).getDataNascita()+"", 
        ((Utente) e).getEmail(), 
        ((Utente) e).getLuogoNascita(), 
        ((Utente) e).getUsername(), 
        ((Utente) e).getPassword(), 
        (e.getId()+""));
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    
    
}

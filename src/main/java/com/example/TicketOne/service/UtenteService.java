package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.UtentiDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Utente;

public class UtenteService {
    
    @Autowired
	private UtentiDAO uDao;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Utente> getUtente(){
		List<Utente> listClients = new ArrayList<Utente>();
		
		for(Entity c : uDao.read().values())
			listClients.add((Utente) c);
		
		return listClients;
	}

    public Utente getUtente(int id){
        return uDao.readOne(id);
    }

	public Utente getUtenteUser(String username){
        return uDao.readUser(username);
    }
	
	public void addUtente(Map<String, String> params) {
		uDao.create(context.getBean(Utente.class, params));
	}
	
	public void delUtente(int id) {
		uDao.delete(id);
	}
	
	public void modUtente(Map<String, String> params) {
		uDao.update(context.getBean(Utente.class, params));
	}
	

}

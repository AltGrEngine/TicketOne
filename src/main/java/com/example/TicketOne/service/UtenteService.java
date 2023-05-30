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
	
	public List<Utente> getProfilo(){
		List<Utente> listClients = new ArrayList<Utente>();
		
		for(Entity c : uDao.read().values())
			listClients.add((Utente) c);
		
		return listClients;
	}

    public Utente getProfilo(int id){
        return uDao.readOne(id);
    }
	
	public void addProfilo(Map<String, String> params) {
		uDao.create(context.getBean(Utente.class, params));
	}
	
	public void delProfilo(int id) {
		uDao.delete(id);
	}
	
	public void modProfilo(Map<String, String> params) {
		uDao.update(context.getBean(Utente.class, params));
	}
	

}

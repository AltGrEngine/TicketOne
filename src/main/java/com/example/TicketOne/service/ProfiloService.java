package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.ProfiliDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Utente;

public class ProfiloService {
    
    @Autowired
	private ProfiliDAO pDao;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Utente> getProfilo(){
		List<Utente> listClients = new ArrayList<Utente>();
		
		for(Entity c : pDao.read().values())
			listClients.add((Utente) c);
		
		return listClients;
	}

    public Utente getProfilo(int id){
        return pDao.readOne(id);
    }
	
	public void addProfilo(Map<String, String> params) {
		pDao.create(context.getBean(Utente.class, params));
	}
	
	public void delProfilo(int id) {
		pDao.delete(id);
	}
	
	public void modProfilo(Map<String, String> params) {
		pDao.update(context.getBean(Utente.class, params));
	}
	

}

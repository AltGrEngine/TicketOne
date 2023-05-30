package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.ProfiliDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Profilo;

public class ProfiloService {
    
    @Autowired
	private ProfiliDAO pDao;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Profilo> getProfilo(){
		List<Profilo> listClients = new ArrayList<Profilo>();
		
		for(Entity c : pDao.read().values())
			listClients.add((Profilo) c);
		
		return listClients;
	}

    public Profilo getProfilo(int id){
        return pDao.readOne(id);
    }
	
	public void addProfilo(Map<String, String> params) {
		pDao.create(context.getBean(Profilo.class, params));
	}
	
	public void delProfilo(int id) {
		pDao.delete(id);
	}
	
	public void modProfilo(Map<String, String> params) {
		pDao.update(context.getBean(Profilo.class, params));
	}
	

}

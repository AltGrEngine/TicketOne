package com.ticketone.progettoTicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.database.BigliettiDAO;
import com.ticketone.progettoTicketOne.models.Biglietti;
import com.ticketone.progettoTicketOne.models.Entity;

public class BigliettiService {

    @Autowired
    private BigliettiDAO bDao;

    public List<Biglietti> getBiglietti(){
		List<Biglietti> listEventi = new ArrayList<Biglietti>();
		
		for(Entity c : bDao.read().values())
			listEventi.add((Biglietti) c);
		
		return listEventi;
	}

    public Biglietti getBiglietti(int id){
        return bDao.readOne(id);
    }
    
}

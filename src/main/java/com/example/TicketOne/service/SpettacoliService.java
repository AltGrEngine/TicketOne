package com.ticketone.progettoTicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.database.SpettacoliDAO;
import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Spettacoli;

public class SpettacoliService {
    
    @Autowired
    private SpettacoliDAO sDao;

    public List<Spettacoli> getSpettacoli(){
		List<Spettacoli> listSpettacoli = new ArrayList<Spettacoli>();
		
		for(Entity c : sDao.read().values())
			listSpettacoli.add((Spettacoli) c);
		
		return listSpettacoli;
	}

    public Spettacoli getSpettacoli(int id){
        return sDao.readOne(id);
    }
}

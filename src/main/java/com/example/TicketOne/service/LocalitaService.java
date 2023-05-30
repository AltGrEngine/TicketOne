package com.ticketone.progettoTicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.database.LocalitaDAO;
import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Localita;

public class LocalitaService {


    
    @Autowired
    private LocalitaDAO locDao;

    public List<Localita> getLocalita(){
		List<Localita> listLocalita = new ArrayList<Localita>();
		
		for(Entity c : locDao.read().values())
			listLocalita.add((Localita) c);
		
		return listLocalita;
	}

    public Localita getLocalita(int id){
        return locDao.readOne(id);
    }
}

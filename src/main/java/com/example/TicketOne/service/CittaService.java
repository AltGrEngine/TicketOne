package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.CittaDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Citta;

public class CittaService {

    @Autowired
    private CittaDAO cDao;

    public List<Citta> getCitta(){
		List<Citta> listLocalita = new ArrayList<Citta>();
		
		for(Entity c : cDao.read().values())
			listLocalita.add((Citta) c);
		
		return listLocalita;
	}

    public Citta getIdCitta(int id){
        return cDao.readOne(id);
    }
}

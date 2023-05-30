package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.GenereDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Genere;

public class GenereService {

    @Autowired
    private GenereDAO gDao;



    public List<Genere> getGenere(){
		List<Genere> listGeneri = new ArrayList<Genere>();
		
		for(Entity c : gDao.read().values())
			listGeneri.add((Genere) c);
		
		return listGeneri;
	}

    public Genere getGenere(int id){
        return gDao.readOne(id);
    }



    
}

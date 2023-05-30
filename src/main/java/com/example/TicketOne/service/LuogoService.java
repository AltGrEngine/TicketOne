package com.ticketone.progettoTicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ticketone.progettoTicketOne.database.LuoghiDAO;
import com.ticketone.progettoTicketOne.models.Entity;
import com.ticketone.progettoTicketOne.models.Luogo;

public class LuogoService {



    @Autowired
    private LuoghiDAO lDao;


    public List<Luogo> getLuogo(){
		List<Luogo> listLuoghi = new ArrayList<Luogo>();
		
		for(Entity c : lDao.read().values())
			listLuoghi.add((Luogo) c);
		
		return listLuoghi;
	}

    public Luogo getLuogo(int id){
        return lDao.readOne(id);
    }
    
}

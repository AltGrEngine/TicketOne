package com.example.TicketOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.TicketOne.database.LuoghiDAO;
import com.example.TicketOne.models.Entity;
import com.example.TicketOne.models.Luogo;

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

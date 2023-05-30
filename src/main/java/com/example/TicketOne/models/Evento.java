package com.example.TicketOne.models;

import java.sql.Date;

public class Evento extends Entity {
    
    private String titolo;
	private Date data_evento; 
	private int id_categoria;
	private int id_luogo;
    
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public Date getData_evento() {
        return data_evento;
    }
    public void setData_evento(Date data_evento) {
        this.data_evento = data_evento;
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public int getId_luogo() {
        return id_luogo;
    }
    public void setId_luogo(int id_luogo) {
        this.id_luogo = id_luogo;
    }
	
    
}

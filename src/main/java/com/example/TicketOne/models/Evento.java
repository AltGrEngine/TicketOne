package com.example.TicketOne.models;

import java.sql.Date;

public class Evento extends Entity {
    
    private String titolo;
	private Date dataevento; 
	private int idcategoria;
	private int idluogo;
    
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public Date getDataevento() {
        return dataevento;
    }
    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }
    public int getIdcategoria() {
        return idcategoria;
    }
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    public int getIdluogo() {
        return idluogo;
    }
    public void setIdluogo(int idluogo) {
        this.idluogo = idluogo;
    }
	
    
}

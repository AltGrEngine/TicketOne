package com.ticketone.progettoTicketOne.models;

import java.sql.Date;

public class Spettacoli extends Entity {
	
	private String titolo;
	private Date data; 
	private int id_Categoria;
	private int id_luogo;
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getId_Categoria() {
		return id_Categoria;
	}
	
	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
	
	public int getId_luogo() {
		return id_luogo;
	}
	
	public void setId_luogo(int id_luogo) {
		this.id_luogo = id_luogo;
	}
}

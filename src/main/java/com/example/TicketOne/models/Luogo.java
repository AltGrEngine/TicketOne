package com.example.TicketOne.models;

public class Luogo extends Entity {
    
    private String nome;
    private Citta citta;

    public Citta getCitta() {
        return citta;
    }
    public void setCitta(Citta citta) {
        this.citta = citta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCitta() {
		return citta != null ? citta.getId() : 0;
	}
	public void setIdCitta(int idcitta) {
		if(this.citta == null) 
			this.citta = new Citta();
		this.citta.setId(idcitta);
	}
    
    
}

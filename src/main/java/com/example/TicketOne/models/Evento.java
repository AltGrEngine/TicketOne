package com.example.TicketOne.models;

import java.sql.Date;

public class Evento extends Entity {
    
    private String titolo;
	private Date dataevento; 
    private int prezzo;
	private Categoria categoria;
	private Luogo luogo;
    private Genere genere;
    
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // -------------------------------------
    public Date getDataevento() {
        return dataevento;
    }
    public void setDataevento(Date dataevento) {
        this.dataevento = dataevento;
    }

    // -------------------------------------
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    // -------------------------------------

    public Genere getGenere() {
        return genere;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public int getIdGenere() {
		return genere != null ? genere.getId() : 0;
	}
	public void setIdGenere(int idgenere) {
		if(this.genere == null) 
			this.genere = new Genere();
		this.genere.setId(idgenere);
	}
    // -------------------------------------

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public int getIdCategoria() {
		return categoria != null ? categoria.getId() : 0;
	}
	public void setIdCategoria(int idcategoria) {
		if(this.categoria == null) 
			this.categoria = new Categoria();
		this.categoria.setId(idcategoria);
	}
    
    // -------------------------------------
    public Luogo getLuogo() {
        return luogo;
    }
    public void setLuogo(Luogo luogo) {
        this.luogo = luogo;
    }
    public int getIdLuogo() {
		return luogo != null ? luogo.getId() : 0;
	}
	public void setIdLuogo(int idluogo) {
		if(this.luogo == null) 
			this.luogo = new Luogo();
		this.luogo.setId(idluogo);
	}
    
}

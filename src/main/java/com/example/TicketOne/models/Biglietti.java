package com.example.TicketOne.models;

public class Biglietti extends Entity{
    
    private String tipologia;
    private int id_profili;
    private int prezzo;
    private int id_data_evento;


    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public int getId_profili() {
        return id_profili;
    }
    public void setId_profili(int id_profili) {
        this.id_profili = id_profili;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getId_data_evento() {
        return id_data_evento;
    }
    public void setId_data_evento(int id_data_evento) {
        this.id_data_evento = id_data_evento;
    }

}

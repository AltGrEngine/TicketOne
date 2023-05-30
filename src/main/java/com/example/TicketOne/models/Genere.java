package com.example.TicketOne.models;

public class Genere extends Entity {
    
    private String tipocat;
    private int id_evento;
    public String getTipocat() {
        return tipocat;
    }
    public void setTipocat(String tipocat) {
        this.tipocat = tipocat;
    }
    public int getId_evento() {
        return id_evento;
    }
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

}

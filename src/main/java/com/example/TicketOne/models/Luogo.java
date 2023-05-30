package com.example.TicketOne.models;

public class Luogo extends Entity {
    
    private String luogo;
    private int id_localita;
    public String getLuogo() {
        return luogo;
    }
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
    public int getId_localita() {
        return id_localita;
    }
    public void setId_localita(int id_localita) {
        this.id_localita = id_localita;
    }

}

package com.ticketone.progettoTicketOne.models;

import java.sql.Date;

public class Profilo extends Entity{
    
    private String nome;
    private String cognome;
    private String email;
    private Date datanascita;
    private String username;
    private String pass;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDatanascita() {
        return datanascita;
    }
    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    
}

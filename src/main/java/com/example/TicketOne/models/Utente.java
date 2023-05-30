package com.example.TicketOne.models;

import java.sql.Date;

public class Utente extends Entity{
    
    private String nome;
    private String cognome;
    private String email;
    private Date datanascita;
    private String username;
    private String password;
    
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    

    
}

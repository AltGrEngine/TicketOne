package com.example.TicketOne.models;

import java.sql.Date;

public class Utente extends Entity{
    
    private String nome;
    private String cognome;
    private Date data_nascita;
    private String email;
    private String luogo_nascita;
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
    public Date getData_nascita() {
        return data_nascita;
    }
    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }
    public String getLuogo_nascita() {
        return luogo_nascita;
    }
    public void setLuogo_nascita(String luogo_nascita) {
        this.luogo_nascita = luogo_nascita;
    }
    

    
}

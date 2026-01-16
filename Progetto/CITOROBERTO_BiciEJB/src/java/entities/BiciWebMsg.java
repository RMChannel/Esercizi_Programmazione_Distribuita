/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 * Oggetto di risposta per il Web Service
 * Contiene solo Nome e Cambio della bici.
 * // MODIFICA: Classe aggiunta per sostituire la stringa nel Web Service
 * @author Roberto
 */
public class BiciWebMsg implements Serializable {
    private String nome;
    private String cambio;

    public BiciWebMsg() {
        this.nome = "Not Found";
        this.cambio = "Not Found";
    }
    
    public BiciWebMsg(String nome, String cambio) {
        this.nome = nome;
        this.cambio = cambio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Roberto
 */
public class CasaDTO implements Serializable {
    private int id;
    private double affitto;
    private String stato;
    
    public CasaDTO() {};
    
    public CasaDTO(int id, double affitto, String stato) {
        this.id = id;
        this.affitto = affitto;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAffitto() {
        return affitto;
    }

    public void setAffitto(double affitto) {
        this.affitto = affitto;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

}

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
public class CalcioDTO implements Serializable {
    private int id;
    private double attacco;
    private double difesa;
    private double indice;
    
    public CalcioDTO() {}

    public CalcioDTO(int id, double attacco, double difesa, double indice) {
        this.id = id;
        this.attacco = attacco;
        this.difesa = difesa;
        this.indice = indice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAttacco() {
        return attacco;
    }

    public void setAttacco(double attacco) {
        this.attacco = attacco;
    }

    public double getDifesa() {
        return difesa;
    }

    public void setDifesa(double difesa) {
        this.difesa = difesa;
    }

    public double getIndice() {
        return indice;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }
}

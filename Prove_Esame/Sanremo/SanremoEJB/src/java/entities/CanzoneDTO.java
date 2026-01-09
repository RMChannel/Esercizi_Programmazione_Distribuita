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
public class CanzoneDTO implements Serializable {
    private String nome;
    private String incipt;
    
    public CanzoneDTO() {}

    public CanzoneDTO(String nome, String incipt) {
        this.nome = nome;
        this.incipt = incipt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIncipt() {
        return incipt;
    }

    public void setIncipt(String incipt) {
        this.incipt = incipt;
    }
    
    
}

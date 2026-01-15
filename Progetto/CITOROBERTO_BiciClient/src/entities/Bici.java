/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Roberto
 */
@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_IN_VENDITA",query="SELECT b FROM Bici b WHERE b.stato=false")
})
public class Bici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cambio;
    private int anno;
    private boolean stato;
    
    public Bici() {}

    public Bici(String nome, String cambio, int anno, boolean stato) {
        this.nome = nome;
        this.cambio = cambio;
        this.anno = anno;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAnno() {
        return anno;
    }
    
    public int getEta() {
        if(this.anno==0) return 0;
        else return LocalDate.now().getYear()-this.anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        String statostr="";
        if(stato) statostr="Venduta";
        else statostr="In vendita";
        return "Bici{" + "id=" + id + ", nome=" + nome + ", cambio=" + cambio + ", anno=" + anno + ", stato=" + statostr + '}';
    }
}

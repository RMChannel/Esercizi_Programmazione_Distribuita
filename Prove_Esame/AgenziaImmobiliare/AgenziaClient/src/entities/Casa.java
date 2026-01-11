/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Roberto
 */
@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_PER_TIPOLOGIA",query="SELECT c FROM Casa c WHERE c.tipologia=:tipologia"),
    @NamedQuery(name="CERCA_PER_CAP",query="SELECT c FROM Casa c WHERE c.cap=:cap"),
    @NamedQuery(name="CERCA_TUTTI",query="SELECT c FROM Casa c"),
    @NamedQuery(name="CERCA_PER_AFFITTO",query="SELECT c FROM Casa c WHERE c.prezzoAffitto<:affitto"),
    @NamedQuery(name="CERCA_PER_AFFITTO_COMPRESO_AND_CAP",query="SELECT c FROM Casa c WHERE c.prezzoAffitto>:affitto1 AND c.prezzoAffitto<:affitto2 AND c.cap=:cap"),
    @NamedQuery(name="CERCA_LIBERI",query="SELECT c FROM Casa c WHERE c.stato='Libero'")
})
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String tipologia;
    private String indirizzo;
    private String cap;
    private double prezzoAffitto;
    private String stato;
    
    public Casa() {}

    public Casa(String tipologia, String indirizzo, String cap, double prezzoAffitto, String stato) {
        this.tipologia = tipologia;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.prezzoAffitto = prezzoAffitto;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public double getPrezzoAffitto() {
        return prezzoAffitto;
    }

    public void setPrezzoAffitto(double prezzoAffitto) {
        this.prezzoAffitto = prezzoAffitto;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.tipologia);
        hash = 97 * hash + Objects.hashCode(this.indirizzo);
        hash = 97 * hash + Objects.hashCode(this.cap);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.prezzoAffitto) ^ (Double.doubleToLongBits(this.prezzoAffitto) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.stato);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casa other = (Casa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.prezzoAffitto) != Double.doubleToLongBits(other.prezzoAffitto)) {
            return false;
        }
        if (!Objects.equals(this.tipologia, other.tipologia)) {
            return false;
        }
        if (!Objects.equals(this.indirizzo, other.indirizzo)) {
            return false;
        }
        if (!Objects.equals(this.cap, other.cap)) {
            return false;
        }
        return Objects.equals(this.stato, other.stato);
    }

    @Override
    public String toString() {
        return "Casa{" + "id=" + id + ", tipologia=" + tipologia + ", indirizzo=" + indirizzo + ", cap=" + cap + ", prezzoAffitto=" + prezzoAffitto + ", stato=" + stato + '}';
    }
}

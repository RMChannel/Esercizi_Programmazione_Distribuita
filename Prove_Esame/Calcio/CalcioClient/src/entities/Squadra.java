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
    @NamedQuery(name="CERCA_TUTTI",query="SELECT s FROM Squadra s"),
    @NamedQuery(name="CERCA_PER_SQUADRA",query="SELECT s FROM Squadra s WHERE s.nome=:nome"),
    @NamedQuery(name="CERCA_PER_LEGA",query="SELECT s FROM Squadra s WHERE s.lega=:lega"),
    @NamedQuery(name="CERCA_PER_ATTACCO",query="SELECT s FROM Squadra s WHERE s.attacco>:attacco"),
    @NamedQuery(name="CERCA_PER_NAZIONE",query="SELECT s FROM Squadra s WHERE s.nazione=:nazione")
})
public class Squadra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nome;
    private String lega;
    private String nazione;
    private double attacco;
    private double difesa;
    private double indice;
    
    public Squadra() {}

    public Squadra(String nome, String lega, String nazione, double attacco, double difesa, double indice) {
        this.nome = nome;
        this.lega = lega;
        this.nazione = nazione;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLega() {
        return lega;
    }

    public void setLega(String lega) {
        this.lega = lega;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.lega);
        hash = 97 * hash + Objects.hashCode(this.nazione);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.attacco) ^ (Double.doubleToLongBits(this.attacco) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.difesa) ^ (Double.doubleToLongBits(this.difesa) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.indice) ^ (Double.doubleToLongBits(this.indice) >>> 32));
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
        final Squadra other = (Squadra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.attacco) != Double.doubleToLongBits(other.attacco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.difesa) != Double.doubleToLongBits(other.difesa)) {
            return false;
        }
        if (Double.doubleToLongBits(this.indice) != Double.doubleToLongBits(other.indice)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.lega, other.lega)) {
            return false;
        }
        return Objects.equals(this.nazione, other.nazione);
    }

    @Override
    public String toString() {
        return "Squadra{" + "id=" + id + ", nome=" + nome + ", lega=" + lega + ", nazione=" + nazione + ", attacco=" + attacco + ", difesa=" + difesa + ", indice=" + indice + '}';
    }
    
}

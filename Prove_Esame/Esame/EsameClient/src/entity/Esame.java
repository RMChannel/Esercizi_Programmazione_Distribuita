/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Roberto
 */
@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_TUTTI",query="SELECT e FROM Esame e"),
    @NamedQuery(name="CERCA_PER_MATRICOLA",query="SELECT e FROM Esame e WHERE e.matricola=:matricola"),
    @NamedQuery(name="CERCA_PER_COGNOME",query="SELECT e FROM Esame e WHERE e.cognomeStudente=:cognomeStudente"),
    @NamedQuery(name="CERCA_ESAMI_SUPERATI",query="SELECT e FROM Esame e WHERE e.voto!='bocciato' AND e.voto!='ritirato' AND e.voto!='assente'"),
    @NamedQuery(name="CERCA_ESAMI_PRESENTE_MATRICOLA",query="SELECT e FROM Esame e WHERE e.voto!='assente' AND e.matricola=:matricola"),
    @NamedQuery(name="CERCA_ESAMI_SUPERATI_MATRICOLA",query="SELECT e FROM Esame e WHERE e.voto!='assente' AND e.voto!='bocciato' AND e.matricola=:matricola"),
    @NamedQuery(name="CERCA_STUDENTI",query="SELECT e FROM Esame e")
})
public class Esame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String matricola;
    private String nomeStudente;
    private String cognomeStudente;
    private LocalDate dataAppello;
    private LocalDate dataImmissione;
    private String voto;
    
    public Esame() {}

    public Esame(String matricola, String nomeStudente, String cognomeStudente, LocalDate dataAppello, LocalDate dataImmissione, String voto) {
        this.matricola = matricola;
        this.nomeStudente = nomeStudente;
        this.cognomeStudente = cognomeStudente;
        this.dataAppello = dataAppello;
        this.dataImmissione = dataImmissione;
        this.voto = voto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNomeStudente() {
        return nomeStudente;
    }

    public void setNomeStudente(String nomeStudente) {
        this.nomeStudente = nomeStudente;
    }

    public String getCognomeStudente() {
        return cognomeStudente;
    }

    public void setCognomeStudente(String cognomeStudente) {
        this.cognomeStudente = cognomeStudente;
    }

    public LocalDate getDataAppello() {
        return dataAppello;
    }

    public void setDataAppello(LocalDate dataAppello) {
        this.dataAppello = dataAppello;
    }

    public LocalDate getDataImmissione() {
        return dataImmissione;
    }

    public void setDataImmissione(LocalDate dataImmissione) {
        this.dataImmissione = dataImmissione;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.matricola);
        hash = 79 * hash + Objects.hashCode(this.nomeStudente);
        hash = 79 * hash + Objects.hashCode(this.cognomeStudente);
        hash = 79 * hash + Objects.hashCode(this.dataAppello);
        hash = 79 * hash + Objects.hashCode(this.dataImmissione);
        hash = 79 * hash + Objects.hashCode(this.voto);
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
        final Esame other = (Esame) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.matricola, other.matricola)) {
            return false;
        }
        if (!Objects.equals(this.nomeStudente, other.nomeStudente)) {
            return false;
        }
        if (!Objects.equals(this.cognomeStudente, other.cognomeStudente)) {
            return false;
        }
        if (!Objects.equals(this.voto, other.voto)) {
            return false;
        }
        if (!Objects.equals(this.dataAppello, other.dataAppello)) {
            return false;
        }
        return Objects.equals(this.dataImmissione, other.dataImmissione);
    }

    @Override
    public String toString() {
        return "Esame{" + "id=" + id + ", matricola=" + matricola + ", nomeStudente=" + nomeStudente + ", cognomeStudente=" + cognomeStudente + ", dataAppello=" + dataAppello + ", dataImmissione=" + dataImmissione + ", voto=" + voto + '}';
    }
        
}

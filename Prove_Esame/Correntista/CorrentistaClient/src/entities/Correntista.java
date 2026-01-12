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
    @NamedQuery(name="CERCA_TUTTI",query="SELECT c FROM Correntista c"),
    @NamedQuery(name="CERCA_PER_COGNOME",query="SELECT c FROM Correntista c WHERE c.cognome=:cognome"),
    @NamedQuery(name="CERCA_PER_IMPIEGO",query="SELECT c FROM Correntista c WHERE c.impiego=:impiego"),
    @NamedQuery(name="CERCA_INSOLVENTI",query="SELECT c FROM Correntista c WHERE c.insolvente=true")
})
public class Correntista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String cognome;
    private String nome;
    private String impiego;
    private boolean insolvente;
    private int nBonificiIngresso;
    private int nBonificiUscita;
    private int nOperazioniTotaliEntrata;
    private int nOperazioniTotaliUscita;
    private double importoIngresso;
    private double importoUscita;
    
    public Correntista() {}

    public Correntista(String cognome, String nome, String impiego, boolean insolvente, int nBonificiIngresso, int nBonificiUscita, int nOperazioniTotaliEntrata, int nOperazioniTotaliUscita, double importoIngresso, double importoUscita) {
        this.cognome = cognome;
        this.nome = nome;
        this.impiego = impiego;
        this.insolvente = insolvente;
        this.nBonificiIngresso = nBonificiIngresso;
        this.nBonificiUscita = nBonificiUscita;
        this.nOperazioniTotaliEntrata = nOperazioniTotaliEntrata;
        this.nOperazioniTotaliUscita = nOperazioniTotaliUscita;
        this.importoIngresso = importoIngresso;
        this.importoUscita = importoUscita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImpiego() {
        return impiego;
    }

    public void setImpiego(String impiego) {
        this.impiego = impiego;
    }

    public boolean isInsolvente() {
        return insolvente;
    }

    public void setInsolvente(boolean insolvente) {
        this.insolvente = insolvente;
    }

    public int getnBonificiIngresso() {
        return nBonificiIngresso;
    }

    public void setnBonificiIngresso(int nBonificiIngresso) {
        this.nBonificiIngresso = nBonificiIngresso;
    }

    public int getnBonificiUscita() {
        return nBonificiUscita;
    }

    public void setnBonificiUscita(int nBonificiUscita) {
        this.nBonificiUscita = nBonificiUscita;
    }

    public int getnOperazioniTotaliEntrata() {
        return nOperazioniTotaliEntrata;
    }

    public void setnOperazioniTotaliEntrata(int nOperazioniTotaliEntrata) {
        this.nOperazioniTotaliEntrata = nOperazioniTotaliEntrata;
    }

    public int getnOperazioniTotaliUscita() {
        return nOperazioniTotaliUscita;
    }

    public void setnOperazioniTotaliUscita(int nOperazioniTotaliUscita) {
        this.nOperazioniTotaliUscita = nOperazioniTotaliUscita;
    }
    
    public int getnTotaleOperazioni() {
        return this.nOperazioniTotaliEntrata+this.nOperazioniTotaliUscita;
    }

    public double getImportoIngresso() {
        return importoIngresso;
    }

    public void setImportoIngresso(double importoIngresso) {
        this.importoIngresso = importoIngresso;
    }

    public double getImportoUscita() {
        return importoUscita;
    }

    public void setImportoUscita(double importoUscita) {
        this.importoUscita = importoUscita;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.cognome);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.impiego);
        hash = 71 * hash + (this.insolvente ? 1 : 0);
        hash = 71 * hash + this.nBonificiIngresso;
        hash = 71 * hash + this.nBonificiUscita;
        hash = 71 * hash + this.nOperazioniTotaliEntrata;
        hash = 71 * hash + this.nOperazioniTotaliUscita;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.importoIngresso) ^ (Double.doubleToLongBits(this.importoIngresso) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.importoUscita) ^ (Double.doubleToLongBits(this.importoUscita) >>> 32));
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
        final Correntista other = (Correntista) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.insolvente != other.insolvente) {
            return false;
        }
        if (this.nBonificiIngresso != other.nBonificiIngresso) {
            return false;
        }
        if (this.nBonificiUscita != other.nBonificiUscita) {
            return false;
        }
        if (this.nOperazioniTotaliEntrata != other.nOperazioniTotaliEntrata) {
            return false;
        }
        if (this.nOperazioniTotaliUscita != other.nOperazioniTotaliUscita) {
            return false;
        }
        if (Double.doubleToLongBits(this.importoIngresso) != Double.doubleToLongBits(other.importoIngresso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.importoUscita) != Double.doubleToLongBits(other.importoUscita)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.impiego, other.impiego);
    }

    @Override
    public String toString() {
        return "Correntista{" + "id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", impiego=" + impiego + ", insolvente=" + insolvente + ", nBonificiIngresso=" + nBonificiIngresso + ", nBonificiUscita=" + nBonificiUscita + ", nOperazioniTotaliEntrata=" + nOperazioniTotaliEntrata + ", nOperazioniTotaliUscita=" + nOperazioniTotaliUscita + ", importoIngresso=" + importoIngresso + ", importoUscita=" + importoUscita + '}';
    }

    
}

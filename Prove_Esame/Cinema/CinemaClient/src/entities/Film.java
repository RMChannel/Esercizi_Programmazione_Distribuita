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
    @NamedQuery(name="CERCA_PER_TITOLO",query="SELECT f FROM Film f WHERE f.titolo=:titolo"),
    @NamedQuery(name="CERCA_PER_REGISTA",query="SELECT f FROM Film f WHERE f.regista=:regista"),
    @NamedQuery(name="CERCA_TUTTI",query="SELECT f FROM Film f"),
    @NamedQuery(name="CERCA_PER_RATING",query="SELECT f FROM Film f WHERE f.rating>:rating"),
    @NamedQuery(name="CERCA_PER_ANNO_AND_RATING",query="SELECT f FROM Film f WHERE f.anno>=:anno1 AND f.anno<=:anno2 AND f.rating>:rating")
})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String titolo;
    private String regista;
    private int anno;
    private float rating;
    private String genere;
    
    public Film() {}

    public Film(String titolo, String regista, int anno, float rating, String genere) {
        this.titolo = titolo;
        this.regista = regista;
        this.anno = anno;
        this.rating = rating;
        this.genere = genere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.titolo);
        hash = 67 * hash + Objects.hashCode(this.regista);
        hash = 67 * hash + this.anno;
        hash = 67 * hash + Float.floatToIntBits(this.rating);
        hash = 67 * hash + Objects.hashCode(this.genere);
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
        final Film other = (Film) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.anno != other.anno) {
            return false;
        }
        if (Float.floatToIntBits(this.rating) != Float.floatToIntBits(other.rating)) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.regista, other.regista)) {
            return false;
        }
        return Objects.equals(this.genere, other.genere);
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titolo=" + titolo + ", regista=" + regista + ", anno=" + anno + ", rating=" + rating + ", genere=" + genere + '}';
    }
}

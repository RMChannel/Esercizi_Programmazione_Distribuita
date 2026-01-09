/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Roberto
 */
@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_TUTTI", query="SELECT c FROM Canzone c"),
    @NamedQuery(name="CERCA_PER_CATEGORIA", query="SELECT c FROM Canzone c WHERE c.categoria=:categoria"),
    @NamedQuery(name="CERCA_PER_ID",query="SELECT c FROM Canzone c WHERE c.id=:id"),
    @NamedQuery(name="CERCA_PER_VOTO",query="SELECT c FROM Canzone c WHERE c.voti_ricevuti>:voto"),
    @NamedQuery(name="CERCA_PER_AUTORE",query="SELECT c FROM Canzone c WHERE c.nome=:nome")
})
public class Canzone implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String nome;
    private String categoria;
    private String incipit;
    private boolean cantato;
    private int voti_ricevuti;
    
    public Canzone() {}

    public Canzone(String nome, String categoria, String incipit, boolean cantato, int voti_ricevuti) {
        this.nome = nome;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.voti_ricevuti = voti_ricevuti;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    public boolean isCantato() {
        return cantato;
    }

    public void setCantato(boolean cantato) {
        this.cantato = cantato;
    }

    public int getVoti_ricevuti() {
        return voti_ricevuti;
    }

    public void setVoti_ricevuti(int voti_ricevuti) {
        this.voti_ricevuti = voti_ricevuti;
    }

    @Override
    public String toString() {
        return "Canzone{" + "id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", incipit=" + incipit + ", cantato=" + cantato + ", voti_ricevuti=" + voti_ricevuti + '}';
    }
}

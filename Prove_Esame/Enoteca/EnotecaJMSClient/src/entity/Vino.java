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

/**
 *
 * @author Roberto
 */
@Entity
@NamedQueries({
    @NamedQuery(name="CERCA_TUTTI",query="SELECT v FROM Vino v"),
    @NamedQuery(name="CERCA_PER_ID",query="SELECT v FROM Vino v WHERE v.id=:id"),
    @NamedQuery(name="CERCA_PER_PREZZO",query="SELECT v FROM Vino v WHERE v.prezzo=:prezzo"),
    @NamedQuery(name="CERCA_PER_VITIGNO",query="SELECT v FROM Vino v WHERE v.vitigno=:vitigno"),
    @NamedQuery(name="CERCA_PER_PROVENIENZA",query="SELECT v FROM Vino v WHERE v.provenienza=:provenienza"),
    @NamedQuery(name="CERCA_PER_PREZZO_MENO",query="SELECT v FROM Vino v WHERE v.prezzo<:prezzo"),
    @NamedQuery(name="CERCA_PER_TIPOLOGIA",query="SELECT v FROM Vino v WHERE v.tipologia=:tipologia")
})
public class Vino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nominativo;
    private String vitigno;
    private String azienda;
    private int bottiglie_disponibile;
    private String provenienza;
    private double prezzo;
    private String tipologia;
    private boolean acquisto;
    
    public Vino() {}

    public Vino(String nominativo, String vitigno, String azienda, int bottiglie_disponibile, String provenienza, double prezzo, String tipologia, boolean acquisto) {
        this.nominativo = nominativo;
        this.vitigno = vitigno;
        this.azienda = azienda;
        this.bottiglie_disponibile = bottiglie_disponibile;
        this.provenienza = provenienza;
        this.prezzo = prezzo;
        this.tipologia = tipologia;
        this.acquisto = acquisto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getVitigno() {
        return vitigno;
    }

    public void setVitigno(String vitigno) {
        this.vitigno = vitigno;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public int getBottiglie_disponibile() {
        return bottiglie_disponibile;
    }

    public void setBottiglie_disponibile(int bottiglie_disponibile) {
        this.bottiglie_disponibile = bottiglie_disponibile;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public boolean isAcquisto() {
        return acquisto;
    }

    public void setAcquisto(boolean acquisto) {
        this.acquisto = acquisto;
    }

    @Override
    public String toString() {
        return "Vino{" + "id=" + id + ", nominativo=" + nominativo + ", vitigno=" + vitigno + ", azienda=" + azienda + ", bottiglie_disponibile=" + bottiglie_disponibile + ", provenienza=" + provenienza + ", prezzo=" + prezzo + ", tipologia=" + tipologia + ", acquisto=" + acquisto + '}';
    }
    
}

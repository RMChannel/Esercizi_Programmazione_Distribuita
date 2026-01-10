/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import calcio.CalcioEJB;
import entities.Squadra;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 *
 * @author Roberto
 */
@Singleton
@LocalBean
@Startup
public class DBPopulator {
    @Inject
    private CalcioEJB ejb;
    
    Squadra s1=new Squadra("Bayer Munich","Bundesliga","Germania",3.4,0.5,92.6);
    Squadra s2=new Squadra("Napoli","Serie A","Italia",2.5,0.8,82.5);
    Squadra s3=new Squadra("Chelsea","Premier League","Inghilterra",2.1,0.5,80.3);
    Squadra s4=new Squadra("Juventus","Serie A","Italia",2.0,0.8,72.7);
    
    @PostConstruct
    public void populaDB() {
        ejb.salvaSquadra(s1);
        ejb.salvaSquadra(s2);
        ejb.salvaSquadra(s3);
        ejb.salvaSquadra(s4);
    }
    
    @PreDestroy
    public void eliminaDB() {
        ejb.eliminaSquadra(s1);
        ejb.eliminaSquadra(s2);
        ejb.eliminaSquadra(s3);
        ejb.eliminaSquadra(s4);
    }
}

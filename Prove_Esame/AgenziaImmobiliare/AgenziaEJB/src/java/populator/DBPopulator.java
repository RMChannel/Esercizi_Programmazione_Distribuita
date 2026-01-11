/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import agenzia.AgenziaEJB;
import entities.Casa;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 *
 * @author Roberto
 */
@Singleton
@Startup
@Stateless
public class DBPopulator {
    @Inject
    private AgenziaEJB ejb;
    
    Casa c1=new Casa("Bilocale","Piazza Portanova","84121",1000,"Libero");
    Casa c2=new Casa("Trilocale","Via Posidonia","84129",800,"Libero");
    Casa c3=new Casa("Bilocale","Lungomare Marconi","84128",1000,"Locato");
    Casa c4=new Casa("Monolocale","Via Guercio","84134",600,"Locato");
    
    @PostConstruct
    public void populadb() {
        ejb.salvaCasa(c1);
        ejb.salvaCasa(c2);
        ejb.salvaCasa(c3);
        ejb.salvaCasa(c4);
    }
    
    @PreDestroy
    public void eliminadb() {
        ejb.rimuoviCasa(c1);
        ejb.rimuoviCasa(c2);
        ejb.rimuoviCasa(c3);
        ejb.rimuoviCasa(c4);
    }
}

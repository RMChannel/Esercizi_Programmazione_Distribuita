/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import canzone.CanzoneEJB;
import entities.Canzone;
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
public class DatabasePopulator {
    @Inject
    private CanzoneEJB ejb;
    
    Canzone c1=new Canzone("Diodato","Pop","Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. E se ti penso sei un'anima",false,10000);
    Canzone c2=new Canzone("Piero Pelù","Rock","Spingi forte spingi forte salta fuori da quel buio. Crescerai aprendo porte tutti i giorni stare pronti",false,13);
    Canzone c3=new Canzone("Bugo e Morgan","Pop","Le buone intenzioni, l'educazione. La tua foto profilo, buonglorno e buonasera. E la gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente",false,5000);
    
    @PostConstruct
    public void popolaDB() {
        ejb.creaCanzone(c1);
        ejb.creaCanzone(c2);
        ejb.creaCanzone(c3);
    }
    
    @PreDestroy
    public void distruggiDB() {
        ejb.rimuoviCanzone(c1);
        ejb.rimuoviCanzone(c2);
        ejb.rimuoviCanzone(c3);
    }
}

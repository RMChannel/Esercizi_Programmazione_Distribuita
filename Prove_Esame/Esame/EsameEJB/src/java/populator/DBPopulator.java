/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import entity.Esame;
import esame.EsameEJB;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.time.LocalDate;

/**
 *
 * @author Roberto
 */
@Singleton
@LocalBean
@Startup
public class DBPopulator {
    @Inject
    EsameEJB ejb;
    
    Esame e1=new Esame("000007","Sofia","Rossi",LocalDate.of(2023,1,17),LocalDate.now(),"assente");
    Esame e2=new Esame("000008","Tommaso","Ferrari",LocalDate.of(2023,2,6),LocalDate.now(),"bocciato");
    Esame e3=new Esame("000009","Vittoria","Romano",LocalDate.of(2023,2,6),LocalDate.now(),"18");
    Esame e4=new Esame("000007","Sofia","Rossi",LocalDate.of(2023,2,6),LocalDate.now(),"30+");
    
    @PostConstruct
    public void populaDB() {
        ejb.salvaEsame(e1);
        ejb.salvaEsame(e2);
        ejb.salvaEsame(e3);
        ejb.salvaEsame(e4);
    }
    
    @PreDestroy
    public void rimuoviDB() {
        ejb.cancellaEsame(ejb.aggiornaEsame(e1));
        ejb.cancellaEsame(ejb.aggiornaEsame(e2));
        ejb.cancellaEsame(ejb.aggiornaEsame(e3));
        ejb.cancellaEsame(ejb.aggiornaEsame(e4));
    }
}

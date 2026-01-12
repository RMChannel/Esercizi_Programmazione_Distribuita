/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import banca.CorrentistaEJB;
import entities.Correntista;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 *
 * @author Roberto
 */
@Startup
@Singleton
public class DBPopulator {
    @Inject
    private CorrentistaEJB ejb;
    
    Correntista c1=new Correntista("Renzi","Matteo","Politico",true,5000,3,7000,10,9000000,3000);
    Correntista c2=new Correntista("Briatore","Flavio","Imprenditore",false,10,200,500,1000,5000,1000000);
    Correntista c3=new Correntista("Bergoglio","Francesco","Papa",false,10,10,10,10,500,500);
    
    @PostConstruct
    public void populaDB() {
        ejb.salvaCorrentista(c1);
        ejb.salvaCorrentista(c2);
        ejb.salvaCorrentista(c3);
    }
    
    @PreDestroy
    public void eliminaDB() {
        ejb.eliminaCorrentista(c1);
        ejb.eliminaCorrentista(c2);
        ejb.eliminaCorrentista(c3);
    }
}

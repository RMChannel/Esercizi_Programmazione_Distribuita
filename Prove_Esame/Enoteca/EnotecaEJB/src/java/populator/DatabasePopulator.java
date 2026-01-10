/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import entity.Vino;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import vino.VinoEJB;

/**
 *
 * @author Roberto
 */
@Singleton
@LocalBean
@Startup
public class DatabasePopulator {
    @Inject
    private VinoEJB ejb;
    
    Vino v1=new Vino("Montevetrano","Cabernet","Colli di Salerno",11,"Italia",60,"Rosso",false);
    Vino v2=new Vino("Terra di Lavoro","Aglianico","Galardi",15,"Italia",50,"Rosso",false);
    Vino v3=new Vino("Influence Miniere","Meunier","Rodolphe Miniere",5,"Francia",70,"Champagne",false);
    
    @PostConstruct
    public void populateDB() {
        ejb.creaVino(v1);
        ejb.creaVino(v2);
        ejb.creaVino(v3);
    }
    
    @PreDestroy
    public void removeDB() {
        ejb.eliminaVino(v1);
        ejb.eliminaVino(v2);
        ejb.eliminaVino(v3);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import bici.BiciEJB;
import entities.Bici;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 *
 * @author Roberto
 */
// MODIFICA: Aggiunto DataSourceDefinition
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDataSource",
        name = "jdbc/EsameDS",
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)
@Startup // Eseguito all'avvio dell'applicazione
@Singleton // Bean Singleton per inizializzazione DB
public class DBPopulator {
    @Inject
    private BiciEJB ejb;
    
    // Dati di esempio richiesti dalla traccia
    Bici b1=new Bici("Bianchi","Shimano Ultegra",2008,false);
    Bici b2=new Bici("Pinarello Nytro","Shimano 105",2011,false);
    Bici b3=new Bici("Cervelo Soloist","Shimano 105",2016,true);
    Bici b4=new Bici("Sava","Shimano 105",2023,false);
    
    @PostConstruct
    public void populadb() {
        // Popola il DB all'avvio
        ejb.salvab(b1);
        ejb.salvab(b2);
        ejb.salvab(b3);
        ejb.salvab(b4);
    }
    
    @PreDestroy
    public void eliminadb() {
        // Pulisce il DB alla chiusura
        ejb.rimuovib(b1);
        ejb.rimuovib(b2);
        ejb.rimuovib(b3);
        ejb.rimuovib(b4);
    }
}

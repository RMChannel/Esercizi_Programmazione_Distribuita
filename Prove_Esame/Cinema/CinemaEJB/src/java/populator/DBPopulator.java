/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package populator;

import cinema.CinemaEJB;
import entities.Film;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

/**
 *
 * @author Roberto
 */
@Singleton
@Startup
public class DBPopulator {
    @Inject
    CinemaEJB ejb;
    
    Film f1=new Film("Pulp Fiction","Qwerty Tarantino",1994, (float) 9.0,"Drama Crime");
    Film f2=new Film("Inception","Cristopher Nolan",2010, (float) 8.9,"Action Adventure");
    Film f3=new Film("Spider-Man","Sam Raimi",2002, (float) 7.3,"Action Fantasy");
    Film f4=new Film("Mean Streets","Martin Scorsese",1973, (float) 7.5,"Drama Crime");
    
    @PostConstruct
    public void popoplaDB() {
        ejb.salvaFilm(f1);
        ejb.salvaFilm(f2);
        ejb.salvaFilm(f3);
        ejb.salvaFilm(f4);
    }
    
    @PreDestroy
    public void rimuoviDB() {
        ejb.cancellaFilm(f1);
        ejb.cancellaFilm(f2);
        ejb.cancellaFilm(f3);
        ejb.cancellaFilm(f4);
    }
}

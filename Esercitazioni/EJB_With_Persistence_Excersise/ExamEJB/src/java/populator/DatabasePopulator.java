/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package populator;

import entity.Esame;
import exam.ExamEJB;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import java.time.LocalDate;

/**
 *
 * @author Roberto
 */
@Singleton
@LocalBean
@Startup
public class DatabasePopulator {
    @Inject
    private ExamEJB ejb;
    
    Esame e1 = new Esame("Roberto","Cito",LocalDate.of(2025,2,11),30);
    Esame e2 = new Esame("Arjel","Buzi",LocalDate.of(2025,3,11),30);
    Esame e3 = new Esame("Daniele","Carpentieri",LocalDate.of(2025,4,11),30);
    Esame e4 = new Esame("Aleksandre","Chikviladze",LocalDate.of(2025,5,11),30);
    
    @PostConstruct
    public void popolaDB() {
        ejb.creaEsame(e1);
        ejb.creaEsame(e2);
        ejb.creaEsame(e3);
        ejb.creaEsame(e4);
    }
    
    @PreDestroy
    public void eliminaDB() {
        ejb.rimuoviEsame(e1);
        ejb.rimuoviEsame(e2);
        ejb.rimuoviEsame(e3);
        ejb.rimuoviEsame(e4);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package exam;

import entity.Esame;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Roberto
 */

@LocalBean
@Stateless(mappedName="ExamEJB")
public class ExamEJB implements ExamEJBRemote {
    @Inject
    EntityManager em;
    
    public void rimuoviEsame(Esame e) {
        em.remove(em.merge(e));
    }
    
    public void creaEsame(Esame e) {
        em.persist(e);
    }
    
    @Override
    public List<Esame> cercaPerCognome(String cognome) {
        TypedQuery<Esame> query=em.createNamedQuery("CERCA_PER_COGNOME",Esame.class);
        query.setParameter("cognome",cognome);
        return query.getResultList();
    }
    
    @Override
    public List<Esame> cercaTutti() {
        TypedQuery<Esame> query=em.createNamedQuery("CERCA_TUTTI",Esame.class);
        return query.getResultList();
    }
}

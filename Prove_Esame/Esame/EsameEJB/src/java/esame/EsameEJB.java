/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esame;

import entity.Esame;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Stateless
@WebService(serviceName="EsameWEBService")
@LocalBean
public class EsameEJB implements EsameEJBRemote {
    @Inject
    EntityManager em;
    
    public void salvaEsame(Esame e) {
        em.persist(e);
    }
    
    public void cancellaEsame(Esame e) {
        em.remove(e);
    }
    
    public Esame aggiornaEsame(Esame e) {
        return em.merge(e);
    }

    @Override
    public List<Esame> cercaStudentiSuperato() {
        TypedQuery query=em.createNamedQuery("CERCA_ESAMI_SUPERATI", Esame.class);
        return query.getResultList();
    }

    @Override
    public List<Esame> cercaAppelliStudentePresente(String matricola) {
        TypedQuery query=em.createNamedQuery("CERCA_ESAMI_PRESENTE_MATRICOLA", Esame.class);
        query.setParameter("matricola",matricola);
        return query.getResultList();
    }
    
    public List<Esame> cercaAppelliStudenteSuperato(String matricola) {
        TypedQuery query=em.createNamedQuery("CERCA_ESAMI_SUPERATI_MATRICOLA", Esame.class);
        query.setParameter("matricola",matricola);
        return query.getResultList();
    }
    
    @WebMethod(operationName="cercaStudenti")
    public String cercaStudenti() {
        TypedQuery query=em.createNamedQuery("CERCA_STUDENTI", Esame.class);
        List<Esame> esami=query.getResultList();
        String result="";
        java.util.Set<String> processed = new java.util.HashSet<>();
        for(Esame e:esami) {
            if (!processed.contains(e.getMatricola())) {
                result+=" | "+e.getNomeStudente()+" "+e.getCognomeStudente()+" "+e.getMatricola();
                processed.add(e.getMatricola());
            }
        }
        return result;
    }
}

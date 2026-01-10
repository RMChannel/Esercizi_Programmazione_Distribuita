/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vino;

import entity.Vino;
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
@LocalBean
@WebService(serviceName="VinoWEBService")
@Stateless
public class VinoEJB implements VinoEJBRemote {
    @Inject
    EntityManager em;
    
    public void creaVino(Vino v) {
        em.persist(v);
    }
    
    public void eliminaVino(Vino v) {
        em.remove(v);
    }
    
    public void aggiornaVino(Vino v) {
        em.merge(v);
    }

    @Override
    public List<Vino> cercaTutti() {
        TypedQuery<Vino> query=em.createNamedQuery("CERCA_TUTTI",Vino.class);
        return query.getResultList();
    }

    @Override
    public List<Vino> cercaPerProvenienza(String provenienza) {
        TypedQuery<Vino> query=em.createNamedQuery("CERCA_PER_PROVENIENZA",Vino.class);
        query.setParameter("provenienza",provenienza);
        return query.getResultList();
    }

    @Override
    public List<Vino> cercaPerPrezzo(double prezzo) {
        TypedQuery<Vino> query=em.createNamedQuery("CERCA_PER_PREZZO_MENO",Vino.class);
        query.setParameter("prezzo",prezzo);
        return query.getResultList();
    }
    
    public Vino cercaPerID(int id) {
        return em.find(Vino.class, id);
    }
    
    @WebMethod(operationName="cercaChampagne")
    public String cercaChampagne() {
        TypedQuery<Vino> query=em.createNamedQuery("CERCA_PER_TIPOLOGIA",Vino.class);
        query.setParameter("tipologia","Champagne");
        return query.getResultList().toString();
    }
}

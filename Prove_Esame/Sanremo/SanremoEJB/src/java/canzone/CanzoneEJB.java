/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package canzone;

import entities.Canzone;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.*;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Roberto
 */
@LocalBean
@WebService(serviceName="SanremoWEBService")
@Stateless
@Interceptors(VotiInterceptor.class)
public class CanzoneEJB implements CanzoneEJBRemote {
    @Inject
    EntityManager em;
    
    public void creaCanzone(Canzone c) {
        em.persist(c);
    }
    
    public void rimuoviCanzone(Canzone c) {
        em.remove(em.merge(c));
    }
    
    public void aggiornaCanzone(Canzone c) {
        em.merge(c);
    }
    
    @Override
    public List<Canzone> cercaTutti() {
        TypedQuery<Canzone> query=em.createNamedQuery("CERCA_TUTTI",Canzone.class);
        return query.getResultList();
    }
    
    @Override
    public List<Canzone> cercaPerCategoria(String categoria) {
        TypedQuery<Canzone> query=em.createNamedQuery("CERCA_PER_CATEGORIA",Canzone.class);
        query.setParameter("categoria",categoria);
        return query.getResultList();
    }
    
    @Override
    public List<Canzone> cercaPerID(int id) {
        TypedQuery<Canzone> query=em.createNamedQuery("CERCA_PER_ID",Canzone.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
    
    @Override
    public List<Canzone> cercaPerVoto(int voto) {
        TypedQuery<Canzone> query=em.createNamedQuery("CERCA_PER_VOTO",Canzone.class);
        query.setParameter("voto",voto);
        return query.getResultList();
    }
    
    public List<Canzone> cercaPerAutore(String nome) {
        TypedQuery<Canzone> query=em.createNamedQuery("CERCA_PER_AUTORE",Canzone.class);
        query.setParameter("nome",nome);
        return query.getResultList();
    }
    
    @WebMethod(operationName="modificaVoti")
    public String modificaVoti(@WebParam(name="id") int id, @WebParam(name="voti") int voti) {
        Canzone c=em.find(Canzone.class,id);
        if(c!=null) {
            c.setVoti_ricevuti(voti);
            em.merge(c);
            return c.toString();
        }
        else {
            return "Autore non trovato";
        }
    }
}

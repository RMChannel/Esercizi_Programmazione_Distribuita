/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banca;

import entities.Correntista;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Stateless
@LocalBean
@WebService(serviceName="CorrentistaWebService")
public class CorrentistaEJB implements CorrentistaEJBRemote {
    @Inject
    private EntityManager em;
    
    @Interceptors(CountInterceptor.class)
    public void salvaCorrentista(Correntista c) {
        em.persist(c);
    }
    
    @Interceptors(CountInterceptor.class)
    public void eliminaCorrentista(Correntista c) {
        em.remove(em.merge(c));
    }
    
    @Interceptors(CountInterceptor.class)
    public void aggiornaCorrentista(Correntista c) {
        em.merge(c);
    }
    
    public Correntista find(int id) {
        return em.find(Correntista.class,id);
    }
    
    @Override
    @Interceptors(CountInterceptor.class)
    public List<Correntista> getAllInsolventi() {
        TypedQuery tq=em.createNamedQuery("CERCA_INSOLVENTI",Correntista.class);
        return tq.getResultList();
    }
    
    @Override
    @Interceptors(CountInterceptor.class)
    public List<Correntista> getAllCorrentistiConOperazioni(int nOperazioni) {
        TypedQuery tq=em.createNamedQuery("CERCA_TUTTI",Correntista.class);
        List<Correntista> correntisti=tq.getResultList();
        List<Correntista> toRemove=new ArrayList();
        for(Correntista c:correntisti) {
            if(c.getnTotaleOperazioni()<=nOperazioni) toRemove.add(c);
        }
        correntisti.removeAll(toRemove);
        return correntisti;
    }
    
    @Override
    @Interceptors({CountInterceptor.class,OperationInterceptor.class})
    public void transazione(int id, double saldo) {
        Correntista c=em.find(Correntista.class,id);
        c.setnBonificiUscita(c.getnBonificiUscita()+1);
        c.setnOperazioniTotaliUscita(c.getnBonificiUscita()+1);
        c.setImportoUscita(c.getImportoUscita()+saldo);
        em.persist(c);
    }
    
    public String correntistaConOperazioni(int nOperazioni) {
        TypedQuery tq=em.createNamedQuery("CERCA_TUTTI",Correntista.class);
        List<Correntista> correntisti=tq.getResultList();
        String result="";
        for(Correntista c:correntisti) {
            if(c.getnTotaleOperazioni()>nOperazioni) result+=" | "+c.getNome()+" "+c.getCognome();
        }
        return result;
    }
}

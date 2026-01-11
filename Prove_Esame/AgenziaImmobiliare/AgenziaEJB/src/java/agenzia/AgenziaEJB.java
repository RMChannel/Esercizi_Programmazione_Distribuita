/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenzia;

import entities.Casa;
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
@LocalBean
@WebService(name="AgenziaWebService")
public class AgenziaEJB implements AgenziaEJBRemote {
    @Inject
    private EntityManager em;
    
    @WebMethod(operationName="salvaCasa")
    public void salvaCasa(Casa c) {
        em.persist(c);
    }
    
    @WebMethod(operationName="rimuoviCasa")
    public void rimuoviCasa(Casa c) {
        em.remove(em.merge(c));
    }
    
    @WebMethod(operationName="aggiornaCasa")
    public void aggiornaCasa(Casa c) {
        em.merge(c);
    }
    
    @WebMethod(operationName="findByID")
    public Casa findByID(int id) {
        return em.find(Casa.class, id);
    }
    
    @WebMethod(operationName="cercaTutti")
    @Override
    public List<Casa> cercaTutti() {
        TypedQuery tq=em.createNamedQuery("CERCA_TUTTI", Casa.class);
        return tq.getResultList();
    }
    
    @WebMethod(operationName="cercaPerAffitto")
    @Override
    public List<Casa> cercaPerAffitto(double affitto) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_AFFITTO", Casa.class);
        tq.setParameter("affitto",affitto);
        return tq.getResultList();
    }
    
    @WebMethod(operationName="cercaPerAffittoCompresoAndCap")
    @Override
    public List<Casa> cercaPerAffittoCompresoAndCap(double affitto1, double affitto2, String cap) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_AFFITTO_COMPRESO_AND_CAP", Casa.class);
        tq.setParameter("affitto1",affitto1);
        tq.setParameter("affitto2",affitto2);
        tq.setParameter("cap",cap);
        return tq.getResultList();
    }
    
    @WebMethod(operationName="cercaCaseLibere")
    public String cercaCaseLibere() {
        TypedQuery tq=em.createNamedQuery("CERCA_LIBERI", Casa.class);
        List<Casa> caseList=tq.getResultList();
        String result="";
        for(Casa c:caseList) {
            result+="\n| "+c.toString();
        }
        System.out.println(result);
        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bici;

import entities.Bici;
import entities.BiciWebMsg;
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
@WebService(serviceName="BiciWebService") // Espone la classe come Web Service SOAP
public class BiciEJB implements BiciEJBRemote {
    @Inject
    private EntityManager em;
    
    // Metodo helper per salvare una bici
    @Override
    @WebMethod(exclude=true) // Escluso dal WSDL
    public void salvab(Bici b) {
        em.persist(b);
    }
    
    // Metodo helper per rimuovere una bici
    @WebMethod(exclude=true)
    public void rimuovib(Bici b) {
        em.remove(em.merge(b));
    }
    
    // Metodo helper per aggiornare una bici
    @WebMethod(exclude=true)
    public void aggiornab(Bici b) {
        em.merge(b);
    }
    
    // Implementa la richiesta A: Restituisce tutte le bici in vendita
    @Override
    @WebMethod(exclude=true)
    public List<Bici> getallinvendita() {
        TypedQuery q=em.createNamedQuery("CERCA_IN_VENDITA",Bici.class);
        return q.getResultList();
    }
    
    // Cerca una bici per ID
    @WebMethod(exclude=true)
    public Bici find(int id) {
        return em.find(Bici.class,id);
    }
    
    // Implementa la richiesta C: Web Service che restituisce Nome e Cambio dato l'ID
    // MODIFICA: Restituisce un oggetto BiciWebMsg invece di String
    @WebMethod
    public BiciWebMsg getNomi(int id) {
        BiciWebMsg msg=new BiciWebMsg();
        Bici b=find(id);
        if(b!=null) {
            msg.setNome(b.getNome());
            msg.setCambio(b.getCambio());
        }
        return msg;
    }
}

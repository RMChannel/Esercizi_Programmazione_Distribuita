/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcio;

import entities.Squadra;
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
@WebService(serviceName="CalcioWebService")
@LocalBean
public class CalcioEJB implements CalcioEJBRemote {
    @Inject
    EntityManager em;
    
    public void salvaSquadra(Squadra s) {
        em.persist(s);
    }
    
    public void eliminaSquadra(Squadra s) {
        em.remove(em.merge(s));
    }
    
    public void aggiornaSquadra(Squadra s) {
        em.merge(s);
    }

    @Override
    public List<Squadra> squadraConAttaccoMiglioreDi(double attacco) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_ATTACCO", Squadra.class);
        tq.setParameter("attacco", attacco);
        return tq.getResultList();
    }

    @Override
    public Squadra squadraMigliore(int squadra1, int squadra2) {
        Squadra s1=em.find(Squadra.class, squadra1);
        Squadra s2=em.find(Squadra.class, squadra2);
        if(s1==null && s2==null) return null;
        else if(s1==null) return s2;
        else if(s2==null) return s1;
        else if(s1.getIndice()>s2.getIndice()) return s1;
        else if(s1.getIndice()==s2.getIndice()) return null;
        else return s2;
    }
    
    public Squadra getSquadra(int id) {
        return em.find(Squadra.class,id);
    }
    
    @WebMethod(operationName="getSquadreByNazione")
    public String getSquadreByNazione(String nazione) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_NAZIONE",Squadra.class);
        tq.setParameter("nazione",nazione);
        List<Squadra> squadre=tq.getResultList();
        String result="";
        for(Squadra s:squadre) {
            result+="| "+s.getNome();
        }
        return result;
    }
}

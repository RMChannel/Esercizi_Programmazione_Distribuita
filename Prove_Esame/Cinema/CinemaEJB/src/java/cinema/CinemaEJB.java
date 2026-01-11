/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import entities.Film;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Roberto
 */
@LocalBean
@Stateless
@WebService(serviceName="CinemaWebService")
public class CinemaEJB implements CinemaEJBRemote {
    @Inject
    EntityManager em;
    
    public void salvaFilm(Film f) {
        em.persist(f);
    }
    
    public void cancellaFilm(Film f) {
        em.remove(em.merge(f));
    }
    
    public void aggiornaFilm(Film f) {
        em.merge(f);
    }
    
    public Film findByID(int id) {
        return em.find(Film.class,id);
    }
    
    @Override
    public List<Film> cercaPerRating(float rating) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_RATING",Film.class);
        tq.setParameter("rating",rating);
        return tq.getResultList();
    }
    
    @Override
    public List<Film> cercaPerAnno(int anno1, int anno2, float rating) {
        TypedQuery tq=em.createNamedQuery("CERCA_PER_ANNO_AND_RATING",Film.class);
        tq.setParameter("anno1",anno1);
        tq.setParameter("anno2",anno2);
        tq.setParameter("rating",rating);
        return tq.getResultList();
    }
    
    public String filmConRatingMaggioreDi8() {
        List<Film> films=cercaPerRating(8);
        String result="";
        for(Film f:films) {
            result+="| "+f.getTitolo();
        }
        return result;
    }
}

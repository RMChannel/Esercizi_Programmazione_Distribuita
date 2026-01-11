/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import entities.Film;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/CinemaTopic")
public class CinemaMDB implements MessageListener {
    @Inject
    CinemaEJB ejb;
    
    @Override
    public void onMessage(Message msg) {
        try {
            Film f=msg.getBody(Film.class);
            if(f.getId()==0) {
                ejb.salvaFilm(f);
                System.out.println("Attenzione: "+f.getTitolo()+" ha un nuovo rating: "+f.getRating());
            }
            else {
                Film film=ejb.findByID(f.getId());
                if(film==null) {
                    System.err.println("Film non trovato");
                }
                else {
                    film.setRating(f.getRating());
                    ejb.aggiornaFilm(film);
                    System.out.println("Aggiornamento rating per il film "+film.getTitolo());
                }
            }
        } catch(JMSException je) {
            System.err.println("Error in onMessage");
        }
    }
}

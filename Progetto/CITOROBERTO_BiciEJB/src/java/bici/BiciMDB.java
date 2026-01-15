/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bici;

import entities.Bici;
import entities.BiciDTO;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/javaee7/Topic") // Ascolta sul Topic specificato
public class BiciMDB implements MessageListener {
    @Inject
    private BiciEJB ejb;
    
    // Implementa la richiesta B: Consuma messaggi per aggiornamento stato
    @Override
    public void onMessage(Message msg) {
        try {
            // Deserializza il messaggio (ID, nuovo stato)
            BiciDTO dto=msg.getBody(BiciDTO.class);
            Bici b=ejb.find(dto.getId());
            if(b==null) {
                System.err.println("Bici non trovata");
                return;
            }
            // Se lo stato passa da "in vendita" (false) a "venduta" (true), stampa avviso
            if(dto.getStato() && !b.getStato()) {
                System.out.println("Nuova bici venduta!");
            }
            // Aggiorna lo stato su DB
            b.setStato(dto.getStato());
            ejb.aggiornab(b);
        } catch(JMSException je) {
            System.err.println("Errore in onMessage()");
        }
    }
}

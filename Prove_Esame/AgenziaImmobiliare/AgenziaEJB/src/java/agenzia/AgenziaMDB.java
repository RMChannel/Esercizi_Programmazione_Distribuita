/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenzia;

import entities.Casa;
import entities.CasaDTO;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/AgenziaTopic")
public class AgenziaMDB implements MessageListener {
    @Inject
    AgenziaEJB ejb;
    
    public void onMessage(Message msg) {
        try {
            CasaDTO dto=msg.getBody(CasaDTO.class);
            if(dto==null) {
                System.err.println("Messaggio vuoto");
                return;
            }
            Casa c=ejb.findByID(dto.getId());
            if(c==null) {
                System.err.println("Casa non trovata");
                return;
            }
            c.setPrezzoAffitto(dto.getAffitto());
            if(!c.getStato().equals(dto.getStato())) {
                c.setStato(dto.getStato());
                System.out.println("Immobile "+c.getTipologia()+" in "+c.getIndirizzo()+" ha cambiato lo stato in "+c.getStato());
            }
            else {
                System.out.println("Aggiornamento immobile "+c.getTipologia()+" in "+c.getIndirizzo());
            }
            ejb.aggiornaCasa(c);
        } catch(JMSException je) {
            System.err.println("Errore in onMessage");
        }
    }
}

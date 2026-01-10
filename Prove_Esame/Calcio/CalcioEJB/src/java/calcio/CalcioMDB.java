/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcio;

import entities.CalcioDTO;
import entities.Squadra;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/CalcioTopic")
public class CalcioMDB implements MessageListener {
    @EJB
    private CalcioEJB ejb;

    @Override
    public void onMessage(Message msg) {
        System.out.println("Messaggio ricevuto");
        try {
            CalcioDTO dto=msg.getBody(CalcioDTO.class);
            Squadra s=ejb.getSquadra(dto.getId());
            if(s==null) {
                System.err.println("Squadra non trovata");
                return;
            }
            if(dto.getIndice()>s.getIndice()) {
                System.out.println(s.getNome()+" ha migliorato l'indice!");
            }
            else if(dto.getIndice()<s.getIndice()) {
                System.out.println("Attenzione: "+s.getNome()+" ha peggiorato l'indice");
            }
            s.setAttacco(dto.getAttacco());
            s.setDifesa(dto.getDifesa());
            s.setIndice(dto.getIndice());
            ejb.aggiornaSquadra(s);
        } catch(JMSException je) {
            System.err.println("Errore in onMessage");
        }
    }
    
}

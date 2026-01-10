/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vino;

import entity.Vino;
import entity.VinoDTO;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/EnotecaTopic")
public class EnotecaMDB implements MessageListener {
    @EJB
    VinoEJB ejb;

    @Override
    public void onMessage(Message msg) {
        try {
            VinoDTO dto;
            dto=msg.getBody(VinoDTO.class);
            Vino v=ejb.cercaPerID(dto.getId());
            if(v==null) {
                System.err.println("ID inserito non trovato");
            }
            else {
                if(dto.getBottiglie()<0) {
                    System.err.println("Valore bottiglie non valido");
                    return;
                }
                else if(dto.getBottiglie()<10) {
                    v.setAcquisto(true);
                    System.out.println("Il vino "+dto.getId()+" deve essere riassortito");
                }
                v.setBottiglie_disponibile(dto.getBottiglie());
                ejb.aggiornaVino(v);
                System.out.println("Aggiornamento effettuato");
            }
        } catch (JMSException je) {
            System.err.println("Errore in onMessage");
        }
    }
}

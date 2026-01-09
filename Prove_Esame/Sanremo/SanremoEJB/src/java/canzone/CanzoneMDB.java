/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canzone;

import entities.Canzone;
import entities.CanzoneDTO;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import java.util.List;

/**
 *
 * @author Roberto
 */
@MessageDriven(mappedName="jms/SanremoTopic")
public class CanzoneMDB implements MessageListener {
    @EJB
    CanzoneEJB ejb;

    @Override
    public void onMessage(Message msg) {
        System.out.println("Nuovo messaggio");
        try {
            CanzoneDTO dto;
            dto=msg.getBody(CanzoneDTO.class);
            System.out.println(dto.getNome()+" "+dto.getIncipt());
            List<Canzone> canzoni=ejb.cercaPerAutore(dto.getNome());
            if(canzoni.isEmpty()) {
                System.err.println("Autore non trovato");
            }
            else {
                for(Canzone c:canzoni) {
                    if(c.getIncipit().equals(dto.getIncipt())) {
                        c.setCantato(true);
                        ejb.aggiornaCanzone(c);
                        System.out.println(c);
                        return;
                    }
                    else if(dto.getNome().equals("Bugo e Morgan") && dto.getIncipt().equals("Le brutte intenzioni, la maleducazione, la tua brutta figura di ieri sera, la tua ingratitudine, la tua arroganza, fai ciò che vuoi mettendo i piedi in testa")) {
                        c.setCantato(true);
                        c.setNome("Morgan");
                        ejb.aggiornaCanzone(c);
                        System.out.println("Dov'e' andato Bugo?");
                    }
                }
            }
        } catch(JMSException je) {
            System.err.println("Error in onMessage");
        }
    }
}

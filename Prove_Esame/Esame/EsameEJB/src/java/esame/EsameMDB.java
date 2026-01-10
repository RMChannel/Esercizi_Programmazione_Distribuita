/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esame;

import entity.Esame;
import esame.EsameEJB;
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
@MessageDriven(mappedName="jms/EsameTopic")
public class EsameMDB implements MessageListener {
    @EJB
    EsameEJB ejb;
    
    public void onMessage(Message msg) {
        System.out.println("Nuovo messaggio");
        try {
            Esame e=msg.getBody(Esame.class);
            if(e!=null) {
                System.out.println(e.getDataImmissione()+": Inserimento per lo studente "+e.getCognomeStudente()+", esito: "+e.getVoto());
                List<Esame> esamiSuperati=ejb.cercaAppelliStudenteSuperato(e.getMatricola());
                if(esamiSuperati.isEmpty() && !e.getVoto().equals("bocciato") && !e.getVoto().equals("assente")) {
                    System.out.println("Finalmente");
                }
            }
            else {
                System.err.println("Messaggio vuoto");
            }
        } catch(JMSException je) {
            System.err.println("Errore in onMessage");
        }
    }
}

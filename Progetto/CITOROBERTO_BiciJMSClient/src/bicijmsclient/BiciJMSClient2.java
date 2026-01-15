/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bicijmsclient;

import entities.BiciDTO;
import jakarta.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class BiciJMSClient2 {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Topic t=(Topic) ctx.lookup("jms/javaee7/Topic");
        JMSContext jc=cf.createContext();
        
        // Imposta ID client per la sottoscrizione durevole
        jc.setClientID("BiciConsumerOfflineSupport");
        
        // Crea un consumatore durevole: riceve messaggi anche se era offline
        JMSConsumer consumer = jc.createDurableConsumer(t, "SottoscrizioneBici");
        
        // Loop infinito per ricevere messaggi
        while(true) {
            BiciDTO dto=consumer.receiveBody(BiciDTO.class);
            if(dto!=null) {
                System.out.println("Messaggio ricevuto=> id:"+dto.getId()+" stato:"+dto.getStato());
            }
        }
    }
}

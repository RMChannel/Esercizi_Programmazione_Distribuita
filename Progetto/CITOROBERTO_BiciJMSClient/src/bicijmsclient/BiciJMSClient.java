/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bicijmsclient;

import entities.BiciDTO;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
// MODIFICA: Classe aggiunta per richiesta B.3
public class BiciJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        // Lookup della ConnectionFactory e del Topic
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/javaee7/Topic");
        
        // Creazione del contesto JMS
        JMSContext jc=cf.createContext();
        
        // Creazione del messaggio di aggiornamento (ID=1, stato=true/venduta)
        BiciDTO dto=new BiciDTO(1,true);
        
        System.out.println("Invio messaggio");
        // Invio del messaggio sul Topic
        jc.createProducer().send(d,dto);
    }
}

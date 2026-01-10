/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calciojmsclient;

import entities.CalcioDTO;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import java.io.Serializable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class CalcioJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/CalcioConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/CalcioTopic");
        JMSContext jc=cf.createContext();
        
        CalcioDTO dto=new CalcioDTO(4,4,4,80);
        
        jc.createProducer().send(d, (Serializable) dto);
        System.out.println("Messaggio inviato");
    }
    
}

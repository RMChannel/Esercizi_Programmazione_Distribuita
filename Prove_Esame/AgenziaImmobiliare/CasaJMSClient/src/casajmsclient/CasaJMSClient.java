/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casajmsclient;

import entities.CasaDTO;
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
public class CasaJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/AgenziaConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/AgenziaTopic");
        JMSContext jc=cf.createContext();
        
        CasaDTO dto=new CasaDTO(1,1200,"Locato");
        
        jc.createProducer().send(d,dto);
        System.out.println("Messaggio inviato");
    }
}

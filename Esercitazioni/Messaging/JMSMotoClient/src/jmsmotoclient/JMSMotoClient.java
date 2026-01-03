/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jmsmotoclient;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import moto.MotoDTO;

/**
 *
 * @author Roberto
 */
public class JMSMotoClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/MotoConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/MotoTopic"); 
        JMSContext jc=cf.createContext();
        
        MotoDTO dto=new MotoDTO("Aprilia RS 250","ZD4VFB0004S","PIRELLI");
        
       jc.createProducer().send(d, dto);
       System.out.println("Messaggio inviato");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esamejmsclient;

import entity.Esame;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import java.time.LocalDate;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class EsameJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/EsameConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/EsameTopic");
        JMSContext jc=cf.createContext();
        
        Esame e=new Esame("000008","Tommaso","Ferrari",LocalDate.now(),LocalDate.now(),"18");
        
        jc.createProducer().send(d,e);
        System.out.println("Esame inviato");
    }
}

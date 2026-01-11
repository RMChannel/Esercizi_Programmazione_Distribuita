/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemajmsclient;

import entities.Film;
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
public class CinemaJMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/CinemaConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/CinemaTopic");
        JMSContext jc=cf.createContext();
        
        Film f=new Film();
        f.setId(1);
        f.setRating(10);
        
        jc.createProducer().send(d,f);
        System.out.println("Aggiornamento Pulp Fiction inviato");
        
        f=new Film("Ritorno al futuro","Steven Spielberg",1985,10,"Adventure Fantasy");
        
        jc.createProducer().send(d,f);
        System.out.println("Inivio Ritorno al futuro");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sanremojmsclient;

import entities.CanzoneDTO;
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
public class SanremoJMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/SanremoConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/SanremoTopic");
        JMSContext jc=cf.createContext();
        
        CanzoneDTO dto=new CanzoneDTO("Diodato","Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. E se ti penso sei un'anima");
        
        jc.createProducer().send(d,dto);
        System.out.println("Diodato inviato");
        
        dto=new CanzoneDTO("Bugo e Morgan","Le brutte intenzioni, la maleducazione, la tua brutta figura di ieri sera, la tua ingratitudine, la tua arroganza, fai ciò che vuoi mettendo i piedi in testa");
        jc.createProducer().send(d,dto);
        System.out.println("Bugo inviato");
    }
    
}

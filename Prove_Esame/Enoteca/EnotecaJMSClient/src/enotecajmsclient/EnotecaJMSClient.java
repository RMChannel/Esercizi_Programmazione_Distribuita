/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enotecajmsclient;

import entity.Vino;
import entity.VinoDTO;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSContext;
import java.util.List;
import java.util.Scanner;
import javax.naming.*;
import vino.VinoEJBRemote;

/**
 *
 * @author Roberto
 */
public class EnotecaJMSClient {
    
    public static void stampaTutti(VinoEJBRemote ejb) {
        List<Vino> vini=ejb.cercaTutti();
        for(Vino v:vini) {
            System.out.println(v.toString());
        }
    }

    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ctx.lookup("jms/EnotecaConnectionFactory");
        Destination d=(Destination) ctx.lookup("jms/EnotecaTopic");
        JMSContext jc=cf.createContext();
        
        VinoEJBRemote ejb=(VinoEJBRemote) ctx.lookup("java:global/EnotecaEJB/VinoEJB!vino.VinoEJBRemote");
        stampaTutti(ejb);
        VinoDTO dto=new VinoDTO();
        Scanner sc=new Scanner(System.in);
        System.out.println("Scegli il vino che vuoi modificare: ");
        dto.setId(sc.nextInt());
        System.out.println("Scegli la quantità bottiglie da inserire: ");
        dto.setBottiglie(sc.nextInt());
        jc.createProducer().send(d,dto);
        System.out.println("Messaggio inviato");
    }
}

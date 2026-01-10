/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcioclient;

import calcio.CalcioEJBRemote;
import entities.Squadra;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class CalcioClient {
    
    public static void stampaSquadraConAttaccoMiglioreDi(CalcioEJBRemote ejb, double attacco) {
        List<Squadra> squadre=ejb.squadraConAttaccoMiglioreDi(attacco);
        for(Squadra s:squadre) {
            System.out.println(s);
        }
    }
    
    public static void squadraMigliore(CalcioEJBRemote ejb, int squadra1, int squadra2) {
        Squadra s=ejb.squadraMigliore(squadra1, squadra2);
        if(s==null) System.out.println("Nessuna squadra trovata o pari");
        else System.out.println(s);
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        CalcioEJBRemote ejb=(CalcioEJBRemote) ctx.lookup("java:global/CalcioEJB/CalcioEJB!calcio.CalcioEJBRemote");
        System.out.println("\nSquadre con attacco migliore di 2.0\n");
        stampaSquadraConAttaccoMiglioreDi(ejb,2.0);
        System.out.println("\nSquadra migliore tra Napoli e Juve\n");
        squadraMigliore(ejb,2,4);
    }
    
}

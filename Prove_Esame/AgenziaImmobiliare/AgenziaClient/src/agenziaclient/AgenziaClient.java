/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenziaclient;

import agenzia.AgenziaEJBRemote;
import entities.Casa;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class AgenziaClient {
    
    public static void cercaPerAffitto(AgenziaEJBRemote ejb, double affitto) {
        List<Casa> caseList=ejb.cercaPerAffitto(affitto);
        for(Casa c:caseList) {
            System.out.println(c.toString());
        }
    }
    
    public static void cercaPerAffittoCompresoAndCap(AgenziaEJBRemote ejb, double affitto1, double affitto2, String cap) {
        List<Casa> caseList=ejb.cercaPerAffittoCompresoAndCap(affitto1,affitto2,cap);
        for(Casa c:caseList) {
            System.out.println(c.toString());
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        AgenziaEJBRemote ejb=(AgenziaEJBRemote) ctx.lookup("java:global/AgenziaEJB/AgenziaEJB!agenzia.AgenziaEJBRemote");
        System.out.println("\nStampa case con affitto minore di 900\n");
        cercaPerAffitto(ejb,900);
        System.out.println("\nStampa case con affitto compreso tra 400 e 700 e cap 84134\n");
        cercaPerAffittoCompresoAndCap(ejb,400,700,"84134");
    }
}

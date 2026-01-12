/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correntistaclient;

import banca.CorrentistaEJBRemote;
import entities.Correntista;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class CorrentistaClient {
    
    public static void stampaCorrentistiInsolventi(CorrentistaEJBRemote ejb) {
        List<Correntista> correntisti=ejb.getAllInsolventi();
        for(Correntista c:correntisti) {
            System.out.println(c);
        }
    }
    
    public static void stmpaCorrentistiConOperazioni(CorrentistaEJBRemote ejb, int operazioni) {
        List<Correntista> correntisti=ejb.getAllCorrentistiConOperazioni(operazioni);
        for(Correntista c:correntisti) {
            System.out.println(c);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        CorrentistaEJBRemote ejb=(CorrentistaEJBRemote) ctx.lookup("java:global/CorrentistaEJB/CorrentistaEJB!banca.CorrentistaEJBRemote");
        System.out.println("\nStampa correntisti insolventi\n");
        stampaCorrentistiInsolventi(ejb);
        System.out.println("\nStampa correntisti con operazioni maggiori a 1000\n");
        stmpaCorrentistiConOperazioni(ejb,1000);
        ejb.transazione(1, 16000);
        ejb.transazione(1, 15000);
    }
}

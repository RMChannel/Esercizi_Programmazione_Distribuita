    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biciclient;

import bici.BiciEJBRemote;
import entities.Bici;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class BiciClient {
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        // Lookup dell'EJB remoto tramite JNDI
        BiciEJBRemote ejb=(BiciEJBRemote) ctx.lookup("java:global/BiciEJB/BiciEJB!bici.BiciEJBRemote");
        
        System.out.println("\nInserisco la nuova bici\n");
        salvaB(ejb); // Inserisce la bici richiesta (b)
        
        System.out.println("\nStampo tutte le bici in vendita:\n");
        printAll(ejb); // Stampa (a)
    }
    
    // Stampa tutte le bici in vendita
    public static void printAll(BiciEJBRemote ejb) {
        List<Bici> bl=ejb.getallinvendita();
        for(Bici b:bl) {
            System.out.println(b);
        }
    }
    
    // Inserisce una nuova bici specifica
    public static void salvaB(BiciEJBRemote ejb) {
        Bici b=new Bici("Bianchi","Shimano Ultegra",2025,false);
        ejb.salvab(b);
    }
}

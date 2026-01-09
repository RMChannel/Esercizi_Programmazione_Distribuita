/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sanremoclient;

import canzone.CanzoneEJBRemote;
import entities.Canzone;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class SanremoClient {
    
    public static void printAll(CanzoneEJBRemote c_ejb_remote) {
        List<Canzone> all=c_ejb_remote.cercaTutti();
        for(Canzone c:all) {
            System.out.println(c);
        }
    }
    
    public static void printByCategory(CanzoneEJBRemote c_ejb_remote, String category) {
        List<Canzone> all=c_ejb_remote.cercaPerCategoria(category);
        for(Canzone c:all) {
            System.out.println(c);
        }
    }
    
    public static void printByVoto(CanzoneEJBRemote c_ejb_remote, int voto) {
        List<Canzone> all=c_ejb_remote.cercaPerVoto(voto);
        for(Canzone c:all) {
            System.out.println(c);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        CanzoneEJBRemote c_ejb_remote=(CanzoneEJBRemote) ctx.lookup("java:global/SanremoEJB/CanzoneEJB!canzone.CanzoneEJBRemote");
        printAll(c_ejb_remote);
        System.out.println("\nRicerca per Pop\n");
        printByCategory(c_ejb_remote, "Pop");
        System.out.println("\nStampa per voti\n");
        printByVoto(c_ejb_remote,4000);
        System.out.println("\nChiamata voto con voto minore di 10\n");
        printByVoto(c_ejb_remote,8);
    }
}

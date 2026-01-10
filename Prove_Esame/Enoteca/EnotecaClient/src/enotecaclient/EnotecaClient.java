/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enotecaclient;

import entity.Vino;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import vino.VinoEJBRemote;

/**
 *
 * @author Roberto
 */
public class EnotecaClient {
    
    public static void stampaTutti(VinoEJBRemote ejb) {
        List<Vino> vini=ejb.cercaTutti();
        for(Vino v:vini) {
            System.out.println(v.toString());
        }
    }
    
        
    public static void stampaPerProvenienza(VinoEJBRemote ejb, String provenienza) {
        List<Vino> vini=ejb.cercaPerProvenienza(provenienza);
        for(Vino v:vini) {
            System.out.println(v.toString());
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        VinoEJBRemote ejb=(VinoEJBRemote) ctx.lookup("java:global/EnotecaEJB/VinoEJB!vino.VinoEJBRemote");
        System.out.println("\nStampo tutti i vini\n");
        stampaTutti(ejb);
        System.out.println("\nStampo per provenienza\n");
        stampaPerProvenienza(ejb,"Italia");
    }
    
}

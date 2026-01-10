/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esameclient;

import entity.Esame;
import esame.EsameEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class EsameClient {
    
    private static void stampaStudentiSuperato(EsameEJBRemote ejb) {
        List<Esame> esami=ejb.cercaStudentiSuperato();
        for(Esame e:esami) {
            System.out.println(e);
        }
    }
    
    private static void cercaAppelliStudentePresente(EsameEJBRemote ejb, String matricola) {
        List<Esame> esami=ejb.cercaAppelliStudentePresente(matricola);
        for(Esame e:esami) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        EsameEJBRemote ejb=(EsameEJBRemote) ctx.lookup("java:global/EsameEJB/EsameEJB!esame.EsameEJBRemote");
        System.out.println("\nStampo gli esami superati\n");
        stampaStudentiSuperato(ejb);
        System.out.println("\nStampo gli esami in cui 000007 era presente\n");
        cercaAppelliStudentePresente(ejb,"000007");
    }
}

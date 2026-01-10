/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esamewebclient;

import esame.EsameEJB;
import esame.EsameWEBService;

/**
 *
 * @author Roberto
 */
public class EsameWebClient { 
    public static void main(String[] args) {
        System.out.println("Avvio Client Web Service...");
        System.out.println(cercaStudenti());
    }
    
    public static String cercaStudenti() {
        EsameWEBService ews=new EsameWEBService();
        EsameEJB ejb=ews.getEsameEJBPort();
        return ejb.cercaStudenti();
    }
}

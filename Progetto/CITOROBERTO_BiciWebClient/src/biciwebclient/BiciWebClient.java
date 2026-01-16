/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biciwebclient;

import web.BiciEJB;
import web.BiciWebMsg;
import web.BiciWebService;

/**
 *
 * @author Roberto
 */
public class BiciWebClient {
    public static void main(String[] args) {
        // Invocazione del Web Service (parte C)
        BiciWebService bws=new BiciWebService();
        BiciEJB ejb=bws.getBiciEJBPort();
        
        // Richiesta di info per ID 1, 4, 100 come da traccia
        stampaMessaggio(ejb,1);
        stampaMessaggio(ejb,4);
        stampaMessaggio(ejb,100);
    }
    
    // MODIFICA: Metodo aggiunto per stampare BiciWebMsg
    public static void stampaMessaggio(BiciEJB ejb, int id) {
        BiciWebMsg msg=ejb.getNomi(id);
        System.out.println("ID: "+id+" Nome: "+msg.getNome()+" Cambio: "+msg.getCambio());
    }
}

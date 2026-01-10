/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enotecawebclient;

import vino.VinoEJB;
import vino.VinoWEBService;

/**
 *
 * @author Roberto
 */
public class EnotecaWebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Avvio Client Web Service...");
        String risultato=cercaChampagne();
        System.out.println(risultato);
    }

    private static String cercaChampagne() {
        VinoWEBService ews=new VinoWEBService();
        VinoEJB port=ews.getVinoEJBPort();
        return port.cercaChampagne();
    }
    
}

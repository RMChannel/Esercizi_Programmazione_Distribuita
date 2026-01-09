/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sanremowebclient;

import canzone.CanzoneEJB;
import canzone.SanremoWEBService;

/**
 *
 * @author Roberto
 */
public class SanremoWebClient {
    public static void main(String[] args) {
        System.out.println("Avvio Client Web Service...");
        // Esempio di invocazione: modifica voti per ID 1 a 500 voti
        String risultato = modificaVoti(1, 500);
        System.out.println("Risultato: " + risultato);
    }
    
    private static String modificaVoti(int id, int voto) {
        SanremoWEBService service = new SanremoWEBService();
        CanzoneEJB port = service.getCanzoneEJBPort();
        return port.modificaVoti(id, voto);
    }
}

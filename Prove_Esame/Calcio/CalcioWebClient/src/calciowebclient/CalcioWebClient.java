/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calciowebclient;

import calcio.CalcioEJB;
import calcio.CalcioWebService;

/**
 *
 * @author Roberto
 */
public class CalcioWebClient {

    public static void main(String[] args) {
        System.out.println("Client Web Avviato\nCerco squadre italiane:\n");
        System.out.println(getSquadreByNazione("Italia"));
    }
    
    public static String getSquadreByNazione(String nazione) {
        CalcioWebService cws=new CalcioWebService();
        CalcioEJB ejb=cws.getCalcioEJBPort();
        return ejb.getSquadreByNazione(nazione);
    }
}

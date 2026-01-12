/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correntistawebclient;

import banca.CorrentistaEJB;
import banca.CorrentistaWebService;

/**
 *
 * @author Roberto
 */
public class CorrentistaWebClient {
    public static void main(String[] args) {
       stampaCorrentisti();
    }
    
    public static void stampaCorrentisti() {
        CorrentistaWebService cws=new CorrentistaWebService();
        CorrentistaEJB ejb=cws.getCorrentistaEJBPort();
        System.out.println(ejb.correntistaConOperazioni(20));
    }
}

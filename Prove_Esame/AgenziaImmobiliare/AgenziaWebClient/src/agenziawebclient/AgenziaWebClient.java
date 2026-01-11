/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenziawebclient;

import agenzia.AgenziaEJBService;
import agenzia.AgenziaWebService;

/**
 *
 * @author Roberto
 */
public class AgenziaWebClient {
    public static void main(String[] args) {
        stampaCaseLibere();
    }
    
    public static void stampaCaseLibere() {
        AgenziaEJBService service=new AgenziaEJBService();
        AgenziaWebService ejb=service.getAgenziaWebServicePort();
        System.out.println("Case libere:\n"+ejb.cercaCaseLibere());
    }
}

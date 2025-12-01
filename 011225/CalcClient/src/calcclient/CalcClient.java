/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calcclient;

import calc.CalcEJBRemote;
import javax.naming.*;
/**
 *
 * @author robertocito
 */
public class CalcClient {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        System.out.println("Start");
        Context ctx=new InitialContext();
        
        System.out.println("Lookup");
        CalcEJBRemote calc=(CalcEJBRemote) ctx.lookup("java:global/CalcServer/CalcEJB!calc.CalcEJBRemote");
        
        System.out.println(calc.add(10, 5));
        System.out.println(calc.sub(10, 5));
        System.out.println(calc.multiply(10, 5));
        System.out.println(calc.count());
    }
    
}

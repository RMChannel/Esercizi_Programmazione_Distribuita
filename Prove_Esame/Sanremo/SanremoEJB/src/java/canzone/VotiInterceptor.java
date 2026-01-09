/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canzone;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Roberto
 */
public class VotiInterceptor {
    private static final AtomicInteger contatore = new AtomicInteger(0);
    
    @AroundInvoke
    public Object ControlloChiamata(InvocationContext ctx) throws Exception {
        String nomeMetodo=ctx.getMethod().getName();
        if(nomeMetodo.equals("cercaPerVoto")) {
            Object[] parametri = ctx.getParameters();
            if(parametri.length>0 && parametri[0] instanceof Integer) {
                int voto=(Integer) parametri[0];
                if(voto<10) {
                    System.out.println("Metodo cercaPerVoto con valore: "+voto+" <10, restituisco null");
                    return null;
                }
            }
        }
        else if(nomeMetodo.equals("cercaTutti") || nomeMetodo.equals("cercaPerCategoria")) {
            int valoreAttuale=contatore.addAndGet(1);
            System.out.println("Contatore metodi: "+valoreAttuale);
        }
        return ctx.proceed();
    }
}

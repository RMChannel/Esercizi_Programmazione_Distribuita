/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banca;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

/**
 *
 * @author Roberto
 */
public class OperationInterceptor {
    @Inject
    private CorrentistaEJB ejb;
    
    @AroundInvoke
    public Object controlloChiamata(InvocationContext ctx) throws Exception {
        Object[] parametri=ctx.getParameters();
        if(ctx.getMethod().getName().equals("transazione")) {
            if(parametri.length<2) {
                System.err.println("Numero parametri errato");
                return null;
            }
            int id=(int) parametri[0];
            double value=(double) parametri[1];
            if(ejb.find(id)==null) {
                System.err.println("Utente non trovato");
                return null;
            }
            else if (value>15000) {
                System.err.println("Valore maggiore della soglia massima");
                return null;
            }
        }
        return ctx.proceed();
    }
}

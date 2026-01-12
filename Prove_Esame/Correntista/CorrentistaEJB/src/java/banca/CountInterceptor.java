/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banca;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import java.util.HashMap;

/**
 *
 * @author Roberto
 */
public class CountInterceptor {
    private static HashMap<String, Integer> count;
    private static final int max=7;
    
    @AroundInvoke
    public Object controlloChiamata(InvocationContext ctx) throws Exception {
        if(count==null) count=new HashMap();
        String nomeMetodo=ctx.getMethod().getName();
        if(!count.containsKey(nomeMetodo)) {
            count.put(nomeMetodo, 0);
        }
        if(count.get(nomeMetodo)<max) {
            count.put(nomeMetodo, count.get(nomeMetodo)+1);
            System.out.println("Invocazione metodo: "+nomeMetodo+"() numero invocazioni "+count.get(nomeMetodo));
            return ctx.proceed();
        }
        else {
            System.out.println("Metodo con massimo numero di invocazioni "+nomeMetodo+"(), numero di invocazioni massime"+max);
            return null;
        }
    }
}
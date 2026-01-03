/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package calc;

import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author robertocito
 */
@Stateless
@LocalBean
public class Counter {
    private int c=0;
    
    public void addOne() {
        c++;
    }
    
    public int getCount() {
        return c;
    }
}

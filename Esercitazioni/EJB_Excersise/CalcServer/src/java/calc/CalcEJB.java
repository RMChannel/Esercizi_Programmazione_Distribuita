/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package calc;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 *
 * @author robertocito
 */
@Stateless
public class CalcEJB implements CalcEJBRemote, CalcEJBLocal {
    @Inject Counter counter;
    
    @Override
    public float add(float a, float b) {
        counter.addOne();
        return a+b;
    }
    
    @Override
    public float sub(float a, float b) {
        counter.addOne();
        return a-b;
    }
    
    @Override
    public float multiply(float a, float b) {
        counter.addOne();
        return a*b;
    }
    
    @Override
    public int count() {
        return counter.getCount();
    }
}

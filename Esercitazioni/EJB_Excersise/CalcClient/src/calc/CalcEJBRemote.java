/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionRemote.java to edit this template
 */
package calc;

import jakarta.ejb.Remote;

/**
 *
 * @author robertocito
 */
@Remote
public interface CalcEJBRemote {
    public float add(float a, float b);
    public float sub(float a, float b);
    public float multiply(float a, float b);
    public int count();
}

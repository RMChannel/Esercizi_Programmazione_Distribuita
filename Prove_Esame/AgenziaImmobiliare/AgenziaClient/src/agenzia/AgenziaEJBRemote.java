/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package agenzia;

import entities.Casa;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface AgenziaEJBRemote {
    public List<Casa> cercaTutti();
    public List<Casa> cercaPerAffitto(double affitto);
    public List<Casa> cercaPerAffittoCompresoAndCap(double affitto1, double affitto2, String cap);
}

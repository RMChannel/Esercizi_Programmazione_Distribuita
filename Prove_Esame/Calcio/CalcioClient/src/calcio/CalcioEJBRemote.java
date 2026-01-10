/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calcio;

import entities.Squadra;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface CalcioEJBRemote {
    public List<Squadra> squadraConAttaccoMiglioreDi(double attacco);
    public Squadra squadraMigliore(int squadra1, int squadra2);
}

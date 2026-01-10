/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vino;

import entity.Vino;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface VinoEJBRemote {
    public List<Vino> cercaTutti();
    public List<Vino> cercaPerProvenienza(String provenienza);
    public List<Vino> cercaPerPrezzo(double prezzo);
}

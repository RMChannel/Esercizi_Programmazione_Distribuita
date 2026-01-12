/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banca;

import entities.Correntista;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface CorrentistaEJBRemote {
    public List<Correntista> getAllInsolventi();
    public List<Correntista> getAllCorrentistiConOperazioni(int nOperazioni);
    public void transazione(int id, double saldo);
}

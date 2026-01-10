/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package esame;

import entity.Esame;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface EsameEJBRemote {
    public List<Esame> cercaStudentiSuperato();
    public List<Esame> cercaAppelliStudentePresente(String matricola);
}

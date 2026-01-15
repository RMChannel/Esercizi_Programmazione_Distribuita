/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bici;

import entities.Bici;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote // Interfaccia Remota per l'EJB
public interface BiciEJBRemote {
    public void salvab(Bici b);
    public List<Bici> getallinvendita();
}

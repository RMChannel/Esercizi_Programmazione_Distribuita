/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionRemote.java to edit this template
 */
package canzone;

import entities.Canzone;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface CanzoneEJBRemote {
    public List<Canzone> cercaTutti();
    public List<Canzone> cercaPerCategoria(String categoria);
    public List<Canzone> cercaPerID(int id);
    public List<Canzone> cercaPerVoto(int voto);
}

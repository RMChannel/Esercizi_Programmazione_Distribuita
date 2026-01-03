/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionRemote.java to edit this template
 */
package exam;

import entity.Esame;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface ExamEJBRemote {
    public List<Esame> cercaPerCognome(String cognome);
    public List<Esame> cercaTutti();
}

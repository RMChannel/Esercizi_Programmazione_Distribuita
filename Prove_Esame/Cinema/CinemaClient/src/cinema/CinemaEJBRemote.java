/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cinema;

import entities.Film;
import jakarta.ejb.Remote;
import java.util.List;

/**
 *
 * @author Roberto
 */
@Remote
public interface CinemaEJBRemote {
    public List<Film> cercaPerRating(float rating);
    public List<Film> cercaPerAnno(int anno1, int anno2, float rating);
}

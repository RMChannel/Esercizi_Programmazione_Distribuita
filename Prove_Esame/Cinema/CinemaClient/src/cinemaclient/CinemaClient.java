/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemaclient;

import cinema.CinemaEJBRemote;
import entities.Film;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Roberto
 */
public class CinemaClient {
    
    public static void stampaFilmConRatingMaggioreDi(CinemaEJBRemote ejb, float rating) {
        List<Film> films=ejb.cercaPerRating(rating);
        for(Film f:films) {
            System.out.println(f);
        }
    }
    
    public static void stampaFilmTraAnniConRatingMaggioreDi(CinemaEJBRemote ejb, int anno1, int anno2, float rating) {
        List<Film> films=ejb.cercaPerAnno(anno1, anno2, rating);
        for(Film f:films) {
            System.out.println(f);
        }
    }
    
    public static void main(String[] args) throws NamingException {
        Context ctx=new InitialContext();
        CinemaEJBRemote ejb=(CinemaEJBRemote) ctx.lookup("java:global/CinemaEJB/CinemaEJB!cinema.CinemaEJBRemote");
        System.out.println("\nStampa film con rating maggiore di 7.6\n");
        stampaFilmConRatingMaggioreDi(ejb, (float) 7.6);
        System.out.println("\nStampa film tra il 1990 e 2000 con rating maggiore di 7.5\n");
        stampaFilmTraAnniConRatingMaggioreDi(ejb,1990,2000,(float) 7.5);
    }
}

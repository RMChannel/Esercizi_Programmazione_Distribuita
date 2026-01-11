/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemawebclient;

import cinema.CinemaEJB;
import cinema.CinemaWebService;

/**
 *
 * @author Roberto
 */
public class CinemaWebClient {
    public static void main(String[] args) {
        stampaFilmConRatingMaggioreDi8();
    }
    
    public static void stampaFilmConRatingMaggioreDi8() {
        CinemaWebService cws=new CinemaWebService();
        CinemaEJB ejb=cws.getCinemaEJBPort();
        System.out.println("Film con rating maggiore di 8: "+ejb.filmConRatingMaggioreDi8());
    }
}

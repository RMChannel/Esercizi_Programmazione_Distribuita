/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookstore;

import javax.persistence.*;
/**
 *
 * @author Roberto
 */
public class BookstoreAnt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookstoreAntPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et= em.getTransaction();
        
        Book b1 = new Book("Harry Potter","Libro bello sui maghi",20);
        Book b2 = new Book("Il Signore degli Anelli","C'è un nano tipo Simone",30);
        
        et.begin();
        em.persist(b1);
        em.persist(b2);
        et.commit();
    }
    
}

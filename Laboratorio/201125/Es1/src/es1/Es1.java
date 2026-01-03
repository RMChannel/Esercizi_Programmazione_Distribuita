/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es1;
import javax.persistence.*;
import java.util.Scanner;


/**
 *
 * @author robbe
 */
public class Es1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory enf=Persistence.createEntityManagerFactory("Es1PU");
        EntityManager em=enf.createEntityManager();
        EntityTransaction et;
        
        Scanner input = new Scanner(System.in);
        int option;
        
        while(true) {
            System.out.println("Scegli:\n[1]Inserisci un libro\n[2]Rimuovi un libro\n[3]Cerca libro per nome\n");
            try {
                option=input.nextInt();
                input.nextLine();
            } catch(Exception e) {
                option=0;
                input.next();
            }
            String title;
            String description;
            double price;
            String ISBN;
            String categoria;
            switch(option) {
                case 1:
                    System.out.print("Inserisci il titolo: ");
                    title=input.nextLine();
                    System.out.print("Inserisci la desrizione: ");
                    description=input.nextLine();
                    System.out.print("Inserisci il prezzo: ");
                    price=input.nextDouble();
                    input.nextLine();
                    System.out.print("Inserisci l'ISBN: ");
                    ISBN=input.nextLine();
                    System.out.print("Inserisci la categoria: ");
                    categoria=input.nextLine();
                    Book b=new Book(title,description,price,ISBN,categoria);
                    et=em.getTransaction();
                    et.begin();
                    em.persist(b);
                    et.commit();
                    break;
                case 2:
                    TypedQuery<Book> tall=em.createQuery("SELECT b FROM Book b",Book.class);
                    for (Book res : tall.getResultList()) {
                            System.out.println(res);
                    }
                    System.out.print("Inserisci l'ISBN del libro che vuoi rimuovere: ");
                    ISBN=input.nextLine();
                    TypedQuery<Book> tq = em.createQuery("SELECT b FROM Book b WHERE b.ISBN = :isbn", Book.class);
                    tq.setParameter("isbn", ISBN);
                    Book bookToDelete = null;
                    try {
                        bookToDelete = tq.getSingleResult();
                    } catch (NoResultException e) {
                        System.out.println("Nessun libro trovato con questo ISBN.");
                        break;
                    }
                    et=em.getTransaction();
                    et.begin();
                    em.remove(bookToDelete);
                    et.commit();
                    System.out.println("Libro eliminato\n");
                    break;
                case 3:
                    int option2;
                    System.out.println("Per cosa vuoi cercare?\n[1]Titolo\n[2]Categoria\n[3]ISBN\n");
                    try {
                        option2=input.nextInt();
                        input.nextLine();
                    } catch(Exception e) {
                        option2=0;
                        input.next();
                    }
                    input.nextLine();
                    TypedQuery<Book> t1;
                    switch(option2) {
                        case 1:
                            System.out.print("Inserisci il titolo da cercare: ");
                            title=input.nextLine();
                            t1=em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :titolo",Book.class);
                            t1.setParameter("titolo","%"+title+"%");
                            for (Book res : t1.getResultList()) {
                                System.out.println(res);
                            }
                            break;
                        case 2:
                            System.out.print("Inserisci la categoria da cercare: ");
                            categoria=input.nextLine();
                            t1=em.createQuery("SELECT b FROM Book b WHERE b.categoria LIKE :categoria",Book.class);
                            t1.setParameter("categoria","%"+categoria+"%");
                            for (Book res : t1.getResultList()) {
                                System.out.println(res);
                            }
                            break;
                        case 3:
                            System.out.print("Inserisci l'ISBN da cercare: ");
                            ISBN=input.nextLine();
                            t1=em.createQuery("SELECT b FROM Book b WHERE b.ISBN LIKE :ISBN",Book.class);
                            t1.setParameter("ISBN","%"+ISBN+"%");
                            for (Book res : t1.getResultList()) {
                                System.out.println(res);
                            }
                            break;
                        default:
                            System.err.println("Opzione non riconosciuta");
                            break;
                    }
                    break;
                default:
                    System.err.println("Opzione non riconosciuta");
            }
        }
        
        //et.commit();
    }
    
}

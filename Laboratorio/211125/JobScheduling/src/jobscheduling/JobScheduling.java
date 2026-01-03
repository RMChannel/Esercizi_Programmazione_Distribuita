/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jobscheduling;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author robbe
 */
public class JobScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory enf=Persistence.createEntityManagerFactory("JobSchedulingPU");
        EntityManager em=enf.createEntityManager();
        EntityTransaction et;
        
        Person p1=new Person("Roberto","","Cito");
        et=em.getTransaction();
        et.begin();
        em.persist(p1);
        et.commit();
        
        Address address=new Address("Nazionale", "Appia", "Santa Maria a Vico", "Italia", "81028");
        et=em.getTransaction();
        et.begin();
        em.persist(address);
        et.commit();
        
        p1.setAddress(address);
        et=em.getTransaction();
        et.begin();
        em.persist(p1);
        et.commit();
        
        Job job1=new Job("Web developer",1500,"Backend");
        Job job2=new Job("Web developer",1000,"Frontend");
        
        et=em.getTransaction();
        et.begin();
        em.persist(job1);
        em.persist(job2);
        et.commit();
        
        p1.addJob(job1);
        p1.addJob(job2);
        
        et=em.getTransaction();
        et.begin();
        em.persist(p1);
        et.commit();
        System.out.println(p1);
    }
    
}

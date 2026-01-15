/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bici;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Roberto
 */
public class ProducerEM {
    @Produces
    @PersistenceContext(unitName="EsamePU") // Collega l'EntityManager alla Persistence Unit "EsamePU"
    EntityManager em;
}

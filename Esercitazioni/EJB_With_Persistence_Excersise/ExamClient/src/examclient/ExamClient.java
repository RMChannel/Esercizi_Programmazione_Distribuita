/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examclient;

import entity.Esame;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import exam.ExamEJBRemote;
import java.util.Scanner;

/**
 *
 * @author Roberto
 */
public class ExamClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ExamEJBRemote ebr=(ExamEJBRemote) ctx.lookup("java:global/ExamEJB/ExamEJB!exam.ExamEJBRemote");
        
        List<Esame> esami=ebr.cercaTutti();
        for(Esame e:esami) {
            System.out.println(e);
        }
        
        Scanner scan=new Scanner(System.in);
        System.out.println("Inserire cognome: ");
        String cognome=scan.nextLine();
        
        esami=ebr.cercaPerCognome(cognome);
        for(Esame e:esami) {
            System.out.println(e);
        }
    }
    
}

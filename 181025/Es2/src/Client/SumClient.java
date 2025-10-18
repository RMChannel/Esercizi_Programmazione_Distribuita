package Client;

import Server.Sum;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SumClient {
    private static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            logger.info("SumClient: main");
            Sum sum = (Sum) Naming.lookup("Sum");
            System.out.println("Inserisci un numero: ");
            int num = sc.nextInt();
            sum.add(num);
            System.out.println("Result: " + sum.result());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "SumClient: main", e);
        }
    }
}


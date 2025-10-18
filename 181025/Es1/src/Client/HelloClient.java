package Client;

import Server.Hello;

import java.rmi.Naming;
import java.util.logging.Logger;

public class HelloClient {
    static Logger logger= Logger.getLogger("global");

    public static void main(String[] args) {
        try {
            logger.info("Cerco oggetto remoto");
            Hello hello=(Hello) Naming.lookup("rmi://localhost/Hello");
            logger.info("Trovato l'oggetto hello");
            System.err.println(hello.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

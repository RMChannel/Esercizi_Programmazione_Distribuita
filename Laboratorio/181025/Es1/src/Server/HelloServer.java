package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class HelloServer extends UnicastRemoteObject implements Hello {
    private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger("global");

    protected HelloServer() throws RemoteException {
    }

    public String sayHello() throws RemoteException {
        logger.info("Hello World!");
        return "Hello World!";
    }

    public static void main(String[] args) throws RemoteException {
        try {
            logger.info("Creo oggetto remoto");
            try {
                LocateRegistry.getRegistry(1099).list();
                logger.info("RMI registry già in esecuzione sulla porta 1099");
            } catch (RemoteException e) {
                logger.info("Avvio RMI registry sulla porta 1099");
                LocateRegistry.createRegistry(1099);
            }
            HelloServer server = new HelloServer();
            logger.info("Effettuo il rebind");
            Naming.rebind("rmi://localhost:1099/Hello", server);
            logger.info("Ready");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

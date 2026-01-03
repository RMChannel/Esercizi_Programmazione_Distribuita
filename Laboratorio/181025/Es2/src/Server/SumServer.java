package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class SumServer extends UnicastRemoteObject implements Sum {
    private int n=0;
    private static Logger logger = Logger.getLogger("global");

    public SumServer() throws RemoteException {
        n=0;
    }

    @Override
    public void add(int num) throws RemoteException {
        logger.info("SumServer: aggiungo " + num);
        n+=num;
    }

    @Override
    public int result() throws RemoteException {
        logger.info("SumServer: result");
        return n;
    }

    public static void main(String[] args) throws RemoteException {
        try {
            logger.info("Creo oggetto remoto");
            LocateRegistry.createRegistry(1099);
            SumServer server = new SumServer();
            logger.info("Effettuo il rebind");
            Naming.rebind("Sum", server);
            logger.info("Ready");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

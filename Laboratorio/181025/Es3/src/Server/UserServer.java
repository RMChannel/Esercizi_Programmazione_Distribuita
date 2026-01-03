package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Logger;

public class UserServer extends UnicastRemoteObject implements UserList {
    private ArrayList<String> users;
    private static Logger logger = Logger.getLogger("global");

    public UserServer() throws RemoteException {
        users = new ArrayList<>();
    }

    @Override
    public void addUser(String user) throws RemoteException {
        logger.info("Adding user: " + user);
        users.add(user);
    }

    @Override
    public void removeUser(String user) throws RemoteException {
        logger.info("Removing user: " + user);
        users.remove(user);
    }

    @Override
    public ArrayList<String> getUsers() throws RemoteException {
        logger.info("Retrieving users");
        return users;
    }

    public static void main(String[] args) throws RemoteException {
        try {
            logger.info("Starting UserServer");
            LocateRegistry.createRegistry(1099);
            UserServer stub = new UserServer();
            logger.info("Effettuo il rebind");
            Naming.rebind("UserServer", stub);
            logger.info("UserServer ready");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

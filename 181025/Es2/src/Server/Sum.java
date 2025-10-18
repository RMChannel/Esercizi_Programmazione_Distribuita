package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sum extends Remote {
    void add(int num) throws RemoteException;
    int result() throws RemoteException;
}

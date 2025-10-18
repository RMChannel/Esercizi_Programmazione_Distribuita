package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserList extends Remote {
    void addUser(String user) throws RemoteException;
    void removeUser(String user) throws RemoteException;
    ArrayList<String> getUsers() throws RemoteException;
}

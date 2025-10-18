package Server;

import Common.Pippo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(300);
        while(true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object=objectInputStream.readObject();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(object.getClass());
            if(!(object instanceof Pippo)) {
                objectOutputStream.writeInt(1);
            }
            else {
                objectOutputStream.writeInt(0);
            }
            objectOutputStream.flush();
            socket.close();
        }
    }
}
package Client;

import Common.Pippo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {
    private static void communicate(Object object) throws IOException {
        Socket socket = new Socket("localhost",300);
        System.out.println("Connected to the server");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(object);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        int result=ois.readInt();
        if(result==1) {
            System.out.println("La classe inviata non era Pippo");
        }
        else if(result==0) {
            System.out.println("La classe inviata era Pippo");
        }
    }

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 9000;
        communicate(host);
        communicate(port);
        communicate(new Pippo());
    }
}
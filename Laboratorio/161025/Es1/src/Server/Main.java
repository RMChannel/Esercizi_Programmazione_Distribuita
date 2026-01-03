package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(300);
        while (true) {
            System.out.println("Attendo connessione...");
            Socket socket = serverSocket.accept();
            System.out.println("Connessione avvenuta con successo!");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object object=objectInputStream.readObject();
            if(object.getClass() != ArrayList.class) {
                throw new RuntimeException("Errrore nella trasmissione client->server");
            }
            ArrayList<Integer>  list=(ArrayList<Integer>) object;
            System.out.println(list);
            int result=list.get(0)+list.get(1);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeInt(result);
            objectOutputStream.flush();
            System.out.println("Risultato inviato");
            socket.close();
            System.out.println("Connessione terminata");
        }
    }
}
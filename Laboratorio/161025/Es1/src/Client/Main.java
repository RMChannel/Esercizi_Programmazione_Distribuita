package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Random random = new Random();
        for(int i=0;i<10;i++) {
            ArrayList<Integer> lista = new ArrayList<>();
            lista.add(random.nextInt(10));
            lista.add(random.nextInt(10));
            System.out.println("Avvio connessione "+(i+1));
            Socket socket = new Socket("localhost",300);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(lista);
            objectOutputStream.flush();
            System.out.println("Lista inviata");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            int result=objectInputStream.readInt();
            System.out.println("Risultato: "+result);
        }
    }
}
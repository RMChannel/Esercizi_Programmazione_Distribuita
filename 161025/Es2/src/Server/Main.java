package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(300,100);
        System.out.println("Server avviato");
        while (true) {
            Socket socket = serverSocket.accept();
            Thread t=new Controller(socket);
            t.start();
        }
    }
}
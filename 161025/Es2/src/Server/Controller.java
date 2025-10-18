package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Controller extends Thread {
    private static ArrayList<Integer> list = new ArrayList<>();
    private final Socket socket;

    public Controller(Socket socket) {
        this.socket = socket;
    }

    private static int getSum(int plus) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum+plus;
    }

    private synchronized void add(int a) {
        list.add(a);
    }

    @Override
    public void run() {
        System.out.println("Client connected");
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            int temp=ois.readInt();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeInt(getSum(temp));
            oos.flush();
            add(temp);
            oos.close();
            socket.close();
            ArrayList<Integer> list2= (ArrayList<Integer>) list.clone();
            System.out.println(list2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

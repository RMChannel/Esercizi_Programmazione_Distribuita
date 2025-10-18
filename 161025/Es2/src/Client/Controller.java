package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Controller extends Thread {

    @Override
    public void run() {
        Random random = new Random();
        try {
            Socket socket=new Socket("localhost",300);
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeInt(random.nextInt(11));
            oos.flush();
            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            int temp=ois.readInt();
            ois.close();
            System.out.println(temp);
            socket.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

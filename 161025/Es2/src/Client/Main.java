package Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<100;i++) {
            Thread t=new Controller();
            t.start();
        }
    }
}
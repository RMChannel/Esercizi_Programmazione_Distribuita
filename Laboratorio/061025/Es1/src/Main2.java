import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        long initTime=System.currentTimeMillis();
        List<CounterThread> threads = new ArrayList<CounterThread>();
        for(int i=0;i<4;i++) {
            CounterThread thread = new CounterThread(counter);
            threads.add(thread);
            thread.start();
        }
        for (CounterThread thread : threads) {
            thread.join();
        }
        long finishTime=System.currentTimeMillis();
        System.out.println("Time taken: "+(finishTime-initTime)+" ms "+counter);
    }
}
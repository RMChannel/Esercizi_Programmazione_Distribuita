import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        int n=999999999;
        int[] numbers=new int[n];
        ArrayList<Thread> threads=new ArrayList<Thread>();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<4;i++) {
            int finalI = i;
            Thread t=new Thread(()->{
                for(int j=0;j<(n/4);j++) {
                    numbers[j+((n/4))* finalI]=42;
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }
}

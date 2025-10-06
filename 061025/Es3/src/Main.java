import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for(int i=1;i<=16;i++){
            testFunction(i);
        }
    }

    public static void testFunction(int nThread) throws InterruptedException {
        System.out.println("Testing: "+nThread);
        int n=520000000;
        int a[]=new int[n];
        int b[]=new int[n];
        ArrayList<Thread> threads=new ArrayList<>();
        for(int i=0;i<nThread;i++) {
            int finalI = i;
            threads.add(new Thread(()->{
                for(int j = 0; j<(a.length/ nThread); j++) {
                    a[j+(n/nThread)*finalI] = j;
                    b[j+(n/nThread)*finalI] = j;
                }
            }));
        }
        long start=System.currentTimeMillis();
        for(Thread thread:threads) {
            thread.start();
        }
        for(Thread thread:threads) {
            thread.join();
        }
        long end=System.currentTimeMillis();
        System.out.println("Tempo inizializzazione: "+(end-start)+"ms");
        threads.clear();
        int c[]=new int[n];
        for(int i=0;i<nThread;i++) {
            int finalI = i;
            threads.add(new Thread(()->{
                for(int j = 0; j<(a.length/ nThread); j++) {
                    c[j+(n/nThread)*finalI] = a[j+(n/nThread)*finalI]+b[j+(n/nThread)*finalI];
                }
            }));
        }
        long start2=System.currentTimeMillis();
        for(Thread thread:threads) {
            thread.start();
        }
        for(Thread thread:threads) {
            thread.join();
        }
        long end2=System.currentTimeMillis();
        System.out.println("Tempo somma: "+(end2-start2)+"ms\n");
    }
}
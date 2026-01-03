public class Main2 {
    public static void main(String[] args) {
        for(int i=1; i<=16; i++) {
            run(i);
        }
    }

    public static void run(int nThread) {
        int N = 9000000;
        int C = 0;

        System.out.println("Test nThread: "+nThread);

        int[] partialCounts = new int[nThread];
        Thread[] threads = new Thread[nThread];

        long startTime = System.nanoTime();

        int iterationsPerThread = N / nThread;

        for (int i = 0; i < nThread; i++) {
            final int threadIndex = i;
            threads[i] = new Thread(() -> {
                int localCount = 0;
                java.util.Random localRandom = new java.util.Random();
                int start = threadIndex * iterationsPerThread;
                int end = (threadIndex == nThread - 1) ? N : (threadIndex + 1) * iterationsPerThread;

                for (int j = start; j < end; j++) {
                    double x = localRandom.nextDouble();
                    double y = localRandom.nextDouble();

                    if (x * x + y * y < 1) {
                        localCount++;
                    }
                }
                partialCounts[threadIndex] = localCount;
            });
            threads[i].start();
        }

        try {
            for (int i = 0; i < nThread; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        C = 0;
        for (int count : partialCounts) {
            C += count;
        }

        double pi = 4.0 * C / N;

        long endTime = System.nanoTime();

        System.out.println("Valore approssimato di π: " + pi+"\nTempo stimato: "+(endTime-startTime)+"ns\n");
    }
}
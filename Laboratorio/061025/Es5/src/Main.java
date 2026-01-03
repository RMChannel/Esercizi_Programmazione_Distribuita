public class Main {
    public static void main(String[] args) {
        int N = 9000000;
        int C = 0;

        java.util.Random random = new java.util.Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            // Genera coordinate casuali tra 0 e 1
            double x = random.nextDouble();
            double y = random.nextDouble();

            if (x * x + y * y < 1) {
                C++;
            }
        }

        double pi = 4.0 * C / N;

        long endTime = System.nanoTime();

        System.out.println("Valore approssimato di π: " + pi+"\nTempo stimato: "+(endTime-startTime)+"ns");
    }
}
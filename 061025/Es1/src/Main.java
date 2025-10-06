public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        long initTime=System.currentTimeMillis();
        for(int i=0;i<40000;i++) {
            counter.incrementa();
        }
        long finishTime=System.currentTimeMillis();
        System.out.println("Time taken: "+(finishTime-initTime)+" ms "+counter);
    }
}
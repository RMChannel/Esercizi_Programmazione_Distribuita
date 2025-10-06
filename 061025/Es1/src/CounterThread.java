public class CounterThread extends java.lang.Thread {
    private final Counter counter;
    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            counter.incrementa();
        }
    }
}

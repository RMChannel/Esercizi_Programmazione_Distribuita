public class Counter {
    private int counter;
    public Counter() {
        this.counter = 0;
    }

    public Counter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public synchronized void incrementa() {
        this.counter++;
    }

    public String toString() {
        return String.valueOf(this.counter);
    }
}

public class Smiley extends Thread {
    private static volatile int count=0;

    public void run() {
        while(true) {
            try {
                synchronized (Smiley.class) {
                    if(count==0) {
                        printDuePunti();
                        count++;
                    }
                    else if(count==1) {
                        printTrattino();
                        count++;
                    }
                    else {
                        printParentesi();
                        count=0;
                    }
                }
            } catch (InterruptedException e)
            { e.printStackTrace(); }
        }
    }
    private void printParentesi() throws InterruptedException{
        System.out.println(")"); Thread.sleep(100);
    }
    private void printTrattino() throws InterruptedException{
        System.out.print("-"); Thread.sleep(100);
    }
    private void printDuePunti() throws InterruptedException{
        System.out.print(":"); Thread.sleep(100);
    }
    public static void main(String[] args) {
        new Smiley().start();
        new Smiley().start();
    }
}
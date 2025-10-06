public class Main {
    public static void main(String[] args) {
        int[] numbers=new int[999000000];
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numbers.length;i++){
            numbers[i]=42;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }
}

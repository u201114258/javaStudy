package threadStudy;

/**
 * Created by cchen on 1/23/2019.
 */

//Never Do it!!!
public class NoVisibility {

    private static boolean ready = false;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run(){
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}

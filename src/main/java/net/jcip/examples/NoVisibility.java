package net.jcip.examples;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 */

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(3000);
        number = 42;
        ready = true;
    }
}
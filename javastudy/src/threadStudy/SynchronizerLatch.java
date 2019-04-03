package threadStudy;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cchen on 3/27/2019.
 */
public class SynchronizerLatch {

    //TestHarness creates a number of threads that run a given task concurrently, return the longest time the task takes
    public long timeTask(int nThreads, final Runnable task) throws InterruptedException {

        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    startGate.await();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endGate.countDown();
                }
            });
            thread.start();
        }

        long startTime = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizerLatch latchTest = new SynchronizerLatch();
        System.out.println(latchTest.timeTask(5, new Thread(() -> {
            System.out.println("A thread is running!");
        })));
    }

}

package concurrency_CN.DeadLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        TestLock2 t2 = new TestLock2();
        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();
    }

    private static class TestLock2 implements Runnable {

        int numsOfTickets = 10;

        //declare lock
        private final ReentrantLock Lock = new ReentrantLock();

        @Override
        public void run() {

            while (true) {
                Lock.lock();//加锁
                try {
                    if (numsOfTickets > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(numsOfTickets--);
                    } else {
                        break;
                    }
                } finally {
                    //解锁
                    Lock.unlock();
                }
            }
        }
    }
}

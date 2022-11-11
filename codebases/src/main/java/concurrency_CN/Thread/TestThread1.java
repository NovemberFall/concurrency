package concurrency_CN.Thread;

/*
    the way that create a new thread:
    1. extends Thread class
    2. override run()
    3. invoke the start() method, start thread

    总结： 线程开启不一定立即执行, 由CPU调度
*/
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("within run() method.");
        }
    }

    public static void main(String[] args) {
        // main thread

        //initialized a thread instance
        TestThread1 testThread1 = new TestThread1();

        //invoke start()
        testThread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Main Thread ...");
        }
    }
}

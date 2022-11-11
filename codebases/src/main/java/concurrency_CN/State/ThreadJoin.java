package concurrency_CN.State;

//想象为插队
public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread VIP coming " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        // Main thread
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();//插队
            }
            System.out.println("Main " + i);
        }
    }
}

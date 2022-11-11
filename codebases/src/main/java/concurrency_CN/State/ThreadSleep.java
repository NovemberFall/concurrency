package concurrency_CN.State;

import concurrency_CN.Thread.TestThread4;

//模拟网络延时
public class ThreadSleep implements Runnable{
    //票数
    private int numOfTickets = 10;

    @Override
    public void run() {
        while (true) {
            if (numOfTickets <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " => Take the ticket: " + numOfTickets-- + " Ticket");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket, "Mia").start();
        new Thread(ticket, "Jim").start();
        new Thread(ticket, "Jake").start();
    }
}

package concurrency_CN.Thread;

//多个线程操作同一个对象
//买火车票的例子
public class TestThread4 implements Runnable{
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
        new Thread(ticket, "Tim").start();
        new Thread(ticket, "Jake").start();
    }
}

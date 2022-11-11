package concurrency_CN.Synchronized_safe;

//安全的购票
public class SafeBuyTickets {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "Mia").start();
        new Thread(buyTicket, "Jake").start();
        new Thread(buyTicket, "Tim").start();
    }
}

class BuyTicket implements Runnable {
    // Ticket
    private int numsOfTickets = 10;
    boolean flag = true;//外部停止方法

    @Override
    public void run() {
        //买票
        while (flag) {

            try {
                //模拟延时
                Thread.sleep(500);
                purchase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Synchronized Method
        //1。 用了synchronized, 每一个线程都会去拿锁，锁的是this => BuyTicket
    private synchronized void purchase() throws InterruptedException {
        //判断是否有票
        if (numsOfTickets <= 0) {
            flag = false;
            return;
        }

        // purchase ticket
        System.out.println(Thread.currentThread().getName() + " get " + numsOfTickets--);
    }
}

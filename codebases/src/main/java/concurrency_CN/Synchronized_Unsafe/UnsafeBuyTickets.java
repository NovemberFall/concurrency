package concurrency_CN.Synchronized_Unsafe;

//不安全的购票
//线程不安全有负数
public class UnsafeBuyTickets {
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
                purchase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void purchase() throws InterruptedException {
        //判断是否有票
        if (numsOfTickets <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);

        // purchase ticket
        System.out.println(Thread.currentThread().getName() + " get " + numsOfTickets--);
    }
}

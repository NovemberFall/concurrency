package concurrency_CN.Synchronized_safe;

//两个人去银行取钱，账户
public class SafeWithdraw {
    public static void main(String[] args) {
        Account account = new Account(1000, "Bank Account");
        Transaction you = new Transaction(account, 50, "You");
        Transaction girlFriend = new Transaction(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }
}

//Account
class Account {
    int balance;
    String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

//bank; simulator withdraw
class Transaction extends Thread {

    Account account;
    int withDraw;
    int currentBalance;

    public Transaction(Account account, int withDraw, String name) {
        super(name);
        this.account = account;
        this.withDraw = withDraw;
    }

    //取钱
    //synchronized 默认锁的是this，这里锁的是 Transaction, 于是我们需要同步块
    @Override
    public void run() {

        //锁的对象就是变化的量，需要增删改查的对象
        synchronized (account) {
            if (account.balance - withDraw < 0) {
                System.out.println(Thread.currentThread().getName() + " Not enough balance!!");
                return;
            }

            //sleep可以检测到问题的根源
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额 = 余额 - withdraw
            account.balance = account.balance - withDraw;

            //你手里的钱，包括你取出来的钱
            currentBalance = currentBalance + withDraw;
            System.out.println(account.name + " balance: " + account.balance);
            System.out.println(Thread.currentThread().getName() + " 手里的钱：" + currentBalance);
        }
    }
}
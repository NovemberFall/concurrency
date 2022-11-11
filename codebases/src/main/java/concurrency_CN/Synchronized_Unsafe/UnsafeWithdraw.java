package concurrency_CN.Synchronized_Unsafe;

//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeWithdraw {
    public static void main(String[] args) {
        Account account = new Account(100, "Money");
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
    @Override
    public void run() {
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
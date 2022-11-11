package concurrency_CN.Thread;

//创建线程方法2： 实现runnable interface, override run(), 执行线程，invoke start()
public class runnableObj implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Within run() => " + i);
        }
    }

    public static void main(String[] args) {
        //create a runnable instance
        runnableObj testThread3 = new runnableObj();

        //create thread instance, 通过线程对象开启我们的线程，代理模式
        new Thread(testThread3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Main thread => " + i);
        }
    }
}

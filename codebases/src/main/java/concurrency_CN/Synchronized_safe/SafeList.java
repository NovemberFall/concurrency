package concurrency_CN.Synchronized_safe;

import java.util.ArrayList;
import java.util.List;

//Safe thread collection
public class SafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        Thread.sleep(3000);

        System.out.println(list.size());
    }
}

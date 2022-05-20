package synchronizeddemo;

import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC安全类型的集合
public class JUCDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(2000);

        System.out.println("list.size() = " + list.size());

    }
}

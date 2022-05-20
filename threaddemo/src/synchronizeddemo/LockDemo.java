package synchronizeddemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();

        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();

    }
}

class TestLock implements Runnable {

    int ticketNums = 10;

//    定义lock锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
//            因为 Thread.sleep()捕捉了异常，所以需要将lock.unlock()写在finally中
            lock.lock();
            try {
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums);
                    ticketNums--;
                } else break;
            }finally {
                lock.unlock();
            }

        }
    }
}

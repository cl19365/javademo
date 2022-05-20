package thread;

//join方法：使指定线程插入运行
public class JoinDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(Thread.currentThread().getName() + " 执行第" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Test test = new Test();
        Thread a = new Thread(joinDemo, "a");
        a.start();
        Thread b = new Thread(test, "b");
        b.start();
        for (int i = 0; i < 30; i++) {
            if(i==15){
                b.join();
            }
            System.out.println("===================");
        }
    }
}

class Test implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.println("["+Thread.currentThread().getName() + " 执行第" + i);
        }
    }
}
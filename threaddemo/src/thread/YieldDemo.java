package thread;
//调用yield方法进行礼让后，此线程由运行状态返回就绪状态
//礼让不一定成功，根据线程执行时CPU的调度决定执行哪个线程
public class YieldDemo {
    public static void main(String[] args) {
        MyYield myYield=new MyYield();

        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"]线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"]线程礼让");
    }
}
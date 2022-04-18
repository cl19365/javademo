package thread;

//模拟网络延时
//每个对象都有一个锁，sleep不会释放锁
public class SleepDemo01 implements Runnable{

//    票数
    private int ticketNumber=10;
    @Override
    public void run() {

        while(true){
            if(ticketNumber<=0){
                break;
            }
            try {
//                模拟网络延时
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 拿到了第"+ticketNumber--+"票");
        }
    }

    public static void main(String[] args) {
        SleepDemo01 testSleep = new SleepDemo01();

        new Thread(testSleep,"用户A").start();
        new Thread(testSleep,"用户B").start();
        new Thread(testSleep,"用户C").start();
    }
}

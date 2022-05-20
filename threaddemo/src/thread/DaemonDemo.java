package thread;
//守护线程
//所有非守护线程死亡后本进程就会结束，不会等待守护线程的结束
public class DaemonDemo {
    public static void main(String[] args) {


        Thread thread01 = new Thread(new DaemonTest01());
        Thread thread02 = new Thread(new DaemonTest02());

        //将指定线程设置为守护线程
        thread01.setDaemon(true);

        thread01.start();
        thread02.start();
//        //测试当前执行的线程是否为守护线程
        System.out.println(thread01.isDaemon());
    }

}

class DaemonTest01 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("DaemonTest01>- " + i);

        }
    }

}

class DaemonTest02 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("DaemonTest02< " + i);

        }
    }

}


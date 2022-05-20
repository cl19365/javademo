package synchronizeddemo;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station," A").start();
        new Thread(station,"B B").start();
        new Thread(station,"CCC").start();

    }
}

class BuyTicket implements Runnable {

    private int ticketNumber = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {

                Thread.sleep(100);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    使用synchronized关键字将方法设置为同步方法
    private  void buy() throws InterruptedException {
//        判断是否有票
        if (ticketNumber <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + " 拿到第" + ticketNumber + "张票");
        ticketNumber--;
    }
}
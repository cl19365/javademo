package synchronizeddemo;

public class UnsafeBank {
    public static void main(String[] args) {
        Account a = new Account(100, "a");
        Drawing A = new Drawing(a, 20, "A");
        A.start();
        Drawing B = new Drawing(a, 100, "B");
        B.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取钱
class Drawing extends Thread {
    Account account;

    //    取出的钱
    int drawingMoney;

    //    现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;

    }

    @Override
    public void run() {
        synchronized (account){
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "余额不足");
                return;
            }

//        sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;
            nowMoney=nowMoney+drawingMoney;

            System.out.println(account.name+"余额为:"+account.money);
            System.out.println(Thread.currentThread().getName()+"手里的钱:"+nowMoney);
        }
    }
}

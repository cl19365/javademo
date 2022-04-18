package thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
//每个对象都有一个锁，sleep不会释放锁
//模拟倒计时
public class SleepDemo02 {

    public static void main(String[] args) throws InterruptedException {
//            tenDown();

//        打印当前系统时间
//        Date startTime =new Date(System.currentTimeMillis());获取当前系统时间

        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
        }
    }

    public static void tenDown() throws InterruptedException {
        int num=10;

        while (num>=0){
            Thread.sleep(1000);
            System.out.println(num--);
        }
        System.out.println("结束");
    }
}

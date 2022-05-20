package thread;
//观察线程状态
//线程进入死亡状态后就不能再次启动
public class ObserveState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===");
            }
        });

//        观察状态
        System.out.println("线程状态 = " + thread.getState());

//        线程启动后
        thread.start();
        System.out.println("线程状态 = " + thread.getState());

//        线程不中止就一直循环
        while (thread.getState()!=Thread.State.TERMINATED){
            Thread.sleep(700);
            System.out.println("线程状态 = " + thread.getState());
        }
    }
}

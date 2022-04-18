package thread;

public class ThreadDemo implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")&&i==10){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gameOver(i)==true){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了  "+i+"步");
        }

    }

    private boolean gameOver(int i) {
        if(winner!=null){
            return true;
        }
        if(i>99){
            winner=Thread.currentThread().getName();
            System.out.println("winner is  " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadDemo td=new ThreadDemo();
        new Thread(td,"乌龟").start();
        new Thread(td,"兔子").start();
    }

}

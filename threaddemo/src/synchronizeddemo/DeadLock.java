package synchronizeddemo;

//死锁：多个线程互相持有对方需要的资源，然后形成僵持
/*
产生死锁的四个必要条件:
1. 互斥条件:一个资源每次只能被一个进程使用。
2. 请求与保持条件:一个进程因请求资源而阻塞时，对已获得的资源保持不放。
3. 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
4. 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。

 */
public class DeadLock {
    public static void main(String[] args) {
        Thread a = new TestC(0, 1);
        Thread b = new TestC(1, 2);
        a.start();
        b.start();
    }
}

class TestA{


}
class TestB{

}
class TestC extends Thread{

    static TestA a=new TestA();
    static TestB b=new TestB();

    int id;
    int num;

        public TestC(int id,int num){
        this.id=id;
        this.num=num;
    }
    @Override
    public void run() {

        if(id==0){
            synchronized (a){
                System.out.println("A");
                synchronized (b){
                    System.out.println("B");
                }
            }
        }else {
            synchronized (b){
                System.out.println("B");
                synchronized (a){
                    System.out.println("A");
                }
            }
        }
    }


}

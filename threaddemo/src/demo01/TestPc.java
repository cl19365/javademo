package demo01;

//测试生产者消费者模型-->利用缓冲区解决:管程法
public class TestPc {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }
}

//生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    //    生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));

        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //    消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.pop();
        }

    }
}

//产品
class Chicken {
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer {

    //    需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    //    容器计算器
    int count = 0;

    //    生产者放入产品
    public synchronized void push(Chicken chicken) {

//        如果容器满了，就需要等待消费者消费
        if (count == chickens.length) {
//            通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        如果没有满就增加产品数量
        chickens[count] = chicken;
        count++;
        System.out.println("生产了" + count + "只鸡");
//        通知消费者消费
        this.notifyAll();
    }

    //    消费者消费产品
    public synchronized void pop() {
//        判断能否消费
        if (count == 0) {
//            等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
//        进行消费
            count--;
            Chicken chicken = chickens[count];

            System.out.println("消费了-->" + chicken.id + "只鸡");
//        通知生产者生产
            this.notifyAll();
        }


    }
}

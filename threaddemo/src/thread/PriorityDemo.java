package thread;

public class PriorityDemo {
    public static void main(String[] args) {

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        // 通过线程类Thread的静态方法currentThread()获取当前正在执行线程
        Thread thread = Thread.currentThread();
        System.out.println(thread);// Thread[main,5,main]

        // 通过线程对象的getId()获取当前线程的标示符
        System.out.println("当前线程的ID是：" + thread.getId());

        // 通过线程对象的getName()获取当前线程的名称
        System.out.println("当前线程的名称是：" + thread.getName());

        // 通过线程对象的setName()更改当前线程的名称
        thread.setName("a");
        System.out.println("更改后线程的名称是：" + thread.getName());

        // 通过线程对象的getPriority()获取当前线程的优先级
        System.out.println("当前线程的优先级是：" + thread.getPriority());

        // 通过线程对象的setPriority()更改当前线程的优先级
        //（如果使用数字设置，那么数字取值范围为1～10，数字越大优先级越高，表示获取cpu资源概率越大）
        thread.setPriority(1);
        System.out.println("更改后线程的优先级是：" + thread.getPriority());

//        thread.setPriority(Thread.MAX_PRIORITY);//静态整型常量，表示将线程优先级设为10
//        thread.setPriority(Thread.NORM_PRIORITY);//静态整型常量，表示将线程优先级设为5
//        thread.setPriority(Thread.MIN_PRIORITY);//静态整型常量，表示将线程优先级设为1
    }

    }

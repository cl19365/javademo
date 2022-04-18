package demo;

//接口实现的几种写法
public class LambdaDemo {
    //    2.静态内部类
    static class Like1 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda1");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        new Like1().lambda();
//        3.局部内部类
        class Like2 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda2");
            }
        }

        new Like2().lambda();

//        匿名内部类：没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        };

        like.lambda();

//        用lambda表达式实现接口（只能实现函数式接口）
//        方法参数的数据类型可以省略，单个参数时可以省略括号
        Number number = (a,b) -> {
            System.out.println("a="+a+"\nb="+b);
        };

        number.printNumber(2,4);
    }
}

//函数式接口：只包含唯一一个抽象方法的接口
interface ILike {
    void lambda();
}
interface Number {
    void printNumber(int a,int b);
}
//1.实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
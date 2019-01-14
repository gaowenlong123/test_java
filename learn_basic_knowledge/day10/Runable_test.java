package day10;

import static java.lang.System.out;

/**
 *
 * 1:  实现类  ，Thread这是继承
 *
 * 创建thread类对象 ，在构造方法中 ，传递Runable接口实现类
 *
 * 2: 避免单继承  ，实现接口更好的分离 ，面向对象  ，操作同一个资源，是共享的 ===》很多好处 。
 *                  即实现对象 ，和运行进行分离
 *
 *
 * Created by Administrator on 2019\1\14 0014.
 */
public class Runable_test {

    public static void main(String[] args) {

        SubRunable sr = new SubRunable();
        Thread t = new Thread(sr);

        t.start();

        for(int i= 0;i<100;i++){

            out.println("main" +i);

        }
    }

    public void test(){

        //匿名内部类

        new Thread(){
            public void run(){
                System.out.println(1);
            }
        }.start();


        //实现接口
                   //这实现了一个接口实现类 ，用多态引用
        Runnable r =new Runnable(){
            public void run(){
                System.out.println(1);
            }
        };

        new Thread(r).start();


        //2
        new Thread(
                new Runnable(){
                    public void run(){
                        System.out.println(1);
                    }
                }
        ).start();


    }
}

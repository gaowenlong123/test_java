package day1;

/**
 * 1：构造函数
 *     私有化构造方法，无法创建该属性的方法
 *
 *      如果有继承父类 ，那么构造器的第一行 一定是 super 或this   ，调用父类构造器（必须直接或间接调用父类）
 * Created by Administrator on 2018\12\29 0029.
 */
public class test6 {

    private int a=10;
    public test6(){
        this(10);  // 调用其他的构造方法
        System.out.print("我是构造函数");


    }

    public test6(int a){
        this.a = a;
        System.out.print("我是构造函数 a ");
    }
}

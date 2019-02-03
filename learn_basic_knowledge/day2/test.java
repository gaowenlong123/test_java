package day2;

/**
 * protected  : 同一包中   ， 不同包中中的子类
 *
 * default :   同一包中
 *
 *
 * 如果类是pubilic  一定与文件同名  ， 并且一个文件只有一个public类
 *
 *
 * 3： 静态代码块 只运行一次 ，无论你new几次
 * 构造代码块 优先于构造方法
 *
 *
 * Created by Administrator on 2018/12/31 0031.
 */
public class test  {

     static {
         System.out.println("我是静态代码块");
    }

    {
        System.out.println("我是构造代码块");
    }

    public test(){
        System.out.println("我是构造方法");
    }

    public static void main(String[] args) {

    }

}

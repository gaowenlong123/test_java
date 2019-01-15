package day11;

/**
 *
 * 1： 将资源对象传入 ，根据这个唯一的资源对象
 *
 * 1：还要控制对这个对象读写的线程安全 ，要不然，我在赋值完 ，刚要打印，结果又赋值了
 * 就要利用 object中 wait notify  。 输入成功，就让输入等待输出 ，写出成功就让写出等输入
 *
 *
 *
 * 即 自己定义 输入赋值完成为true 让线程唤起 ，当下次进来为true，就不能再赋值了，就需要让线程等待
 *
 * 在输出方法中，将该值操作了，就设为false ！！！
 *
 * 最后还要用对象去调用 wait notify  ，这样就可以实现读一个，输出一个！！！！！！！！！！
 *
 * Created by Administrator on 2019\1\15 0015.
 */
public class test
{

    public static void main(String[] args) {

        Resource r = new Resource();

        input i =new input(r);
        ouput o =new ouput(r);

         Thread t0 = new Thread(i);
        Thread t1 = new Thread(o);

        t0.start();
        t1.start();
    }
}

package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * 1： 为了优化 run方法没有返回值，不能抛异常
 *
 *
 *
 *
 * Created by Administrator on 2019\1\15 0015.
 */
public class Callable_test {

    public static void main(String[] args) throws Exception {

        //调工厂类的静态方法  ， 返回是一个接口
        ExecutorService es = Executors.newFixedThreadPool(2);

        //返回 future接口的实现类
        Future<String> fu = es.submit(new Sub_Callable());
        Future<String> fu2 =es.submit(new Sub_Callable());
        Future<String> fu3 =es.submit(new Sub_Callable());   //只创建了两个线程 ，所有等有空余线程，再执行

        String s = fu.get();
    }
}

package day10;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 1：将线程放进容器中  ， 用的话给他拿出来，添加一个任务   ，用完不删除，再放回去
 *   需要用 工厂类
 *
 * Created by Administrator on 2019\1\15 0015.
 */
public class Thread_Pool
{

    public static void main(String[] args) {

        //调工厂类的静态方法  ， 返回是一个接口
        ExecutorService es = Executors.newFixedThreadPool(2);

        //将Runnable的实现类，传入进去
        es.submit(new SubRunable());
        es.submit(new SubRunable());
        es.submit(new SubRunable());   //只创建了两个线程 ，所有等有空余线程，再执行

    }
}

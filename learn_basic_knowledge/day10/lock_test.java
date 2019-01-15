package day10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 1： 解决同步方法 synchronized，出现异常，造成死锁
 *
 * 用lock 接口
 *
 * Created by Administrator on 2019\1\15 0015.
 */
public class lock_test implements Runnable
{
    private int ticket =0;

    private Lock lock = new ReentrantLock();

    public void run() {

        while (true) {

                //调用lock，获取锁
                lock.lock();

                if (ticket > 0) {

                    try {

                        ticket--;

                    }catch (Exception e){

                    }finally {
                        lock.unlock();  //必须执行
                    }

                }

        }
    }
}

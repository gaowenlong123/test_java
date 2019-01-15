package day10;

/**
 *
 * 1: 线程不安全， 为了保证安全，将资源放进同步区域里
 *
 *          没有锁的线程，只能等待
 *
 *  2：简化 ,将同步放到方法里  ，不要对象，用本类的this
 *
 * Created by Administrator on 2019\1\15 0015.
 */


public class Synchronized_test implements Runnable{

    private Object obj = new Object();   //没有意义

    int ticket =0;

    public void run(){

//        while (true){
//
//            synchronized (obj){  ///任意对象  ，当做对象监视器 ，锁
//
//                if(ticket >0){
//
//                    ticket--;
//                }
//
//            }
//        }


        //2 简化
        while (true){

            pay();
        }

    }


    public synchronized void pay(){

//        synchronized (this){  ///任意对象  ，当做对象监视器 ，锁
//
//                if(ticket >0){
//
//                    ticket--;
//                }
//
//            }

        if(ticket >0){
            ticket--;
        }
    }
}

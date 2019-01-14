package day10;

import static java.lang.System.out;

/**
 *
 * 1：
 *
 *
 *
 * Created by Administrator on 2019\1\14 0014.
 */
public class Thread_test {

    public static void main(String[] args) throws Exception {

//        SubThread st =new SubThread();
        SubThread st = new SubThread("hahaha");
//        st.setName("haha");
        st.start();

        for(int i= 0;i<100;i++){
            Thread.sleep(1000); //静态方法 ，直接调 ，要抛异常
            System.out.println("main" + i);

        }

        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(Thread.currentThread().getName());

    }
}

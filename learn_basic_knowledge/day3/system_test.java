package day3;

/**
 *
 * 1：
 *
 *
 * Created by Administrator on 2019\1\6 0006.
 */
public class system_test {

    public void finalize(){
        System.out.println("垃圾收取了");
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for(int i =0 ; i<200000;i++){

        }
        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public void exit_test(){
        //退出虚拟机

        System.exit(0);
    }

    public void gc(){   //JVM在内存中，收取垃圾对象
        new system_test();
        new system_test();
        new system_test();
        new system_test();
        new system_test();
        new system_test();


        System.gc();
    }

    public static void test03(){
        System.out.println(System.getProperties());  //得到当前操作系统的属性
    }

}

package day5;

/**
 *
 * 1: 方法的 可变参数   : 本质就是一个数组
 *
 * 必须写在最后
 *
 *
 * Created by Administrator on 2019\1\9 0009.
 */
public class varargs_test {

    public static void main(String[] args) {

//        a();
//        a(1,4,5,6);

    }

    public static int a (int ... num){
        return 2;
    }

    public static int a2 (String a,int ... num){
        return 2;
    }

    public static int a (Object ... num){
        return 2;
    }
}

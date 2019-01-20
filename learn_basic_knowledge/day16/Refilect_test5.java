package day16;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 1:反射获取成员方法并运行
 *
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class Refilect_test5 {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("day16.person");
        Object obj = c.newInstance();

//        Method[] methods = c.getMethods();
//        for (Method m : methods){
//            System.out.println(m);
//        }


        //这些方法运行以字符串体现出来，而不是谁的方法
        Method m = c.getMethod("eat");
        Method m1 = c.getMethod("sleep", int.class);
        m.invoke(obj);
        m1.invoke(obj,10);
    }
}

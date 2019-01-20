package day16;

/**
 *
 * 1:反射获取构造方法并运行 ， 快捷的
 *          前提1：反射类必须有空参构造器
 *              2：构造器的方法必须是public
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class Reflect_test3 {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("day16.person");

        Object obj = c.newInstance();

        System.out.println(obj);


    }
}

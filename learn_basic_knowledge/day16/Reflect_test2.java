package day16;

import java.lang.reflect.Constructor;

/**
 *
 * 1：通过反射获取class文件的构造方法 ， 运行构造方法，创建对象
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class Reflect_test2 {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("day16.person");

        //获取空参构造器 , 没有参数就是得到空参
        Constructor con = c.getConstructor(int.class , String.class); // namenullage0
//        Constructor con = c.getConstructor(); // namenullage0
//        Object obj = con.newInstance();

        Constructor con2 = c.getDeclaredConstructor(int.class);//获得私有构造器，不推荐，破坏安全性
        con2.setAccessible(true);  // 就可以进行实例化了


        Object obj = con.newInstance( 10,"aaaa" );
        person p = (person)obj;
        p.eat();
        System.out.println(obj);


        //只能拿pubilc的权限
//        Constructor[] constructors = c.getConstructors();
//        for(Constructor cons : constructors){
//            System.out.println(cons);
//        }
    }
}

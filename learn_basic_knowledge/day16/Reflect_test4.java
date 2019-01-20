package day16;

import java.lang.reflect.Field;

/**
 *
 * 1;反射获取成员变量，并修改值
 *
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class Reflect_test4 {

    public static void main(String[] args) throws Exception {

        Class c = Class.forName("day16.person");
        Object obj = c.newInstance();

//        Field[] fields = c.getFields()
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }

        //修改值
        Field f1 = c.getField("name");

        f1.set(obj , "ahhahaah");
        System.out.println(obj);


    }

}

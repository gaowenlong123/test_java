package day16;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * 1；定义集合，泛型为String
 *      要求向泛型中加入 Interger
 *
 *
 * Created by Administrator on 2019\1\20 0020.
 */
public class Refilct_test7 {
    public static void main(String[] args) throws Exception {

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aa");
//        arrayList.add(1);  这样是加不进去的

        //取出ArrayList的class文件，直接调add ,编译中的class是没有泛型，可以传入Object对象
        Class c =arrayList.getClass();

        Method m = c.getMethod("add" ,Object.class);  //66666666666666!!
        m.invoke(arrayList ,10);

        System.out.println(arrayList);

    }


}

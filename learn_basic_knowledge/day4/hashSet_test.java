package day4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * 1 ： 不重复  ，无须
 * 1： 实现了 hashmap 的实例
 *
 *
 *2 : 底层结构为 哈希表   ，存储和运行快    ， 线程不安全
 *
 *
 * 3 ： String 类的hash是自己重写方法算出来的，所有字符串相同的hash值相同
 *
 *
 * 4： 所以在写新的类时候  ，可以重写hashcode   ，然后存在set集合里面的值也是有一定的意义 ，
 *并且为了防止重复还要重写 eqauls
 *
 *
 * Created by Administrator on 2019\1\8 0008.
 */
public class hashSet_test {

    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();

        set.add("aa");
        set.add("aa");
        set.add("vvv");
        set.add("vvv");

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for(String s : set){
            System.out.println(s);
        }
    }


    //重写
    private String name;
    private int age;

    public int hashCode(){
//        return name.hashCode()+age;
        final  int prime = 31;
        int result =1 ;
        result = prime * result+age;
        result = prime * result+((name == null) ? 0 : name.hashCode());
        return result;

    }



    public boolean equals(Object obj){           //防止自己重写的方法搞出来相同hash值
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof hashSet_test){
            hashSet_test a = new hashSet_test();
            return name.equals(a.name) && age == a.age;
        }
        return false;
    }

}

package day4;

import java.util.ArrayList;

/**
 * 0： 有些接口会写 < E > ,意思是我先规定有泛型 ，当new子类的实现 <String> 泛型。那么就只能该类型
 * 方便调用者调用
 *
 * 1：集合 与 数组的区别
 *          1： 集合长度可变  ，数组长度固定
 *          2： 集合存储的元素，必须是引用类型数据
 *
 *
 * 2： 在集合中添加 基本类型  ，会进行自动装箱，把基本类型转成对应引用类型
 *
 *
 * 3：
 *                  list        arraylist
 *                              linkedlist
 *   collection
 *                  set         hashset
 *                              linkedhashset
 *
 *4：数组.length
 *   字符串.length()
 *   集合.size()
 *
 *
 *
 */
public class ArrayList_test {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(10);

        for(int i =0; i<arr.size() ; i++){
            System.out.println(arr.get(i));
        }

        ArrayList<test> arr2 = new ArrayList<>(); //存类的对象

        arr2.add(new test("aa"));
        arr2.add(new test("bb"));

        for(int i =0; i<arr2.size() ; i++){
            System.out.println(arr2.get(i));  //可以重写tostring
        }


    }
}

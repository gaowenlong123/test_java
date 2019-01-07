package day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *迭代器  ： 做集合遍历
 *
 *
 * < ? >遍历的通配符 ，只适用用于 遍历类  。
 *
 * Created by Administrator on 2019\1\7 0007.
 */
public class iterator {
    public static void main(String[] args) {
        Collection<String> arr1 =new ArrayList<String>();
        arr1.add("aa");
//        arr1.add(1);   报错 因为<> 泛型，已经发、把元素固定住了

        Iterator<String> it = arr1.iterator();
//        Boolean b=it.hasNext();
//        String temp = it.next();

        //
        while (it.hasNext()){
            String temp2 = it.next();

        }

        //可以不加类型，但是默认object ，需要转型
        Collection arr2 =new ArrayList();
        arr2.add("aa");
        Iterator it2 = arr1.iterator();
        while (it2.hasNext()){
            String temp2 = (String) it2.next();

        }
    }

    public void for_plus(){

        int[] arr = {1,2,3,4,5};


        for(int i : arr){  //只能遍历

        }
    }

    public void fanxing_ToSring(){
        ArrayList<Integer> arr1 =new ArrayList<Integer>();
                                            //泛型集合 tosring
        Integer[] a = new Integer[arr1.size()];
        Integer[] j = arr1.toArray(a);
    }


}

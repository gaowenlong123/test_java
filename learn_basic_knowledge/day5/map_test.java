package day5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * 1：map  和 collection 没有关系   。 map 成对的储存
 *
 * hashmap<k ,v>    无序
 * Linkedhashmap<k ,v >
 *
 *
 *
 * Created by Administrator on 2019\1\9 0009.
 */
public class map_test {

    public static void main(String[] args) {

    }

    public void a(){

        Map<String , Integer> map = new HashMap<String , Integer>();

        map.put("a",1);
        map.put("b",2);

        Integer b = map.get("a");
        Integer b1 =map.remove("b");


        Set<String> set = map.keySet();   //将Key值 生成set集合 ，然后生成 或者加强for


        //3  enrtyset  , 将映射关系存在set集合
        //泛型的嵌套
        Set<Map.Entry<String ,Integer>> set1 = map.entrySet();

        Iterator<Map.Entry<String ,Integer>> it =set1.iterator();
        while (it.hasNext()){
            Map.Entry<String ,Integer> entry = it.next();

            String key = entry.getKey();
            Integer value = entry.getValue();
        }
//----------------------------------------------------------------

        for (Map.Entry<String ,Integer> entry :map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

        }


    }

}

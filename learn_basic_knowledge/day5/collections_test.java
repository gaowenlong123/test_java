package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 1:集合的静态方法
 *
 *
 *
 * Created by Administrator on 2019\1\9 0009.
 */
public class collections_test {

    public static void main(String[] args) {

        List<String> l =  new ArrayList<String>();

        l.add("a");
        l.add("a1");
        l.add("a2");
        l.add("a3");

        Integer index = Collections.binarySearch(l ,"a");
    }

}

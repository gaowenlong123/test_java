package day3;

import java.util.Arrays;

/**
 *
 * Created by Administrator on 2019\1\6 0006.
 */
public class Arrays_test {

    public void sort_test(){
        int[] arr = {5,22,6,7,2};

        Arrays.sort(arr);   //对数组直接进行操作

    }

    public void search_test(){
        int[] arr = {5,22,6,7,2};
        int index =Arrays.binarySearch(arr ,22);   //查找数组中的值的索引

    }

    public void toString_test(){
        int[] arr = {5,22,6,7,2};
        String s  =Arrays.toString(arr);   //
        System.out.println(s);
    }

}

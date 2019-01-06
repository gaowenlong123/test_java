package day1;

/**
 * 1：数组
 *
 *2: 二维数组
 * int [][]   arr = new  int[3][4] ;
 * [3]:二维数组中有三个一维数组
 * [4]:三个一维数组，他们的长度为4
 *
 * Created by Administrator on 2018\12\27 0027.
 */
public class test3 {

    int[] arr = new int[3];

    int[] arr2 = new int[]{1,2,3,4};
    int[] _arr2 = {1,2,3,4,5};

    int[][] arr3 = {{1,2,3},{3,4}};

    public static void main(String []args){

    }

    protected void abc(){
        for(int i = 0 ; i < arr2.length ;i++) {
            System.out.print(i);
        }
    }

}


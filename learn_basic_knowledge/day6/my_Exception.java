package day6;

/**
 *
 * 1： 自定义异常
 *
 *
 * Created by Administrator on 2019\1\12 0012.
 */
public class my_Exception extends Exception {

    public my_Exception(String s){   //这样抛出这个异常就可以输出信息了
        super(s);
    }



}

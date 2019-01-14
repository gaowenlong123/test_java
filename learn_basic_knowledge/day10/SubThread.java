package day10;

/**
 * 1： 继承thread方法  ，重写 run方法
 *
 *
 *
 * Created by Administrator on 2019\1\14 0014.
 */

import static java.lang.System.out;
import static java.lang.System.setProperties;

public class SubThread extends Thread{

    public SubThread( String name){
        super(name);
    }


    public void run(){
        for(int i= 0;i<100;i++){

            out.println(super.getName());

        }
    }
}

package day1;

/**
 * 1 : 条件判断语句
 *
 * 2 : 循环语句
 *
 * 3: break  终止循环    continue 终止本次循环
 * Created by Administrator on 2018\12\26 0026.
 */

import java.util.Random;
public class test2 {

    public static void main(String []args){
        Random ran = new Random();
        int id=ran.nextInt(50);
        ran.nextInt();  // 0-100
        ran.nextDouble(); // 0.0-1.0
        System.out.print(id);

            //1
        if(id ==1){
            int a;
        }

        //2
        if(id ==2){

        }else {

        }

        //3
        if(id ==3){

        }else if (id==4){

        }else {

        }

        while (id <1){
            id++;
        }

        for(int i =0 ; i<id ; i++){

        }

        do {

        }while (id <100);

        switch (id){    //id 为 int char enums string
            case 1:
                break;
            case 2:
                break;
            case 3:   //3 4 输出的一样
            case 4:

                break;
            default:
                break;
        }
    }
}

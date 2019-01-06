package day3;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * 1:
 *
 *2:超过long的范围  ，需要使用 BigInteger类型
 *
 *
 *
 * Created by Administrator on 2019\1\6 0006.
 */
public class integer_test {

    public static void main(String[] args) {
         int i = Integer.parseInt("11");    //字符串生成基本类型
         int i2 = Integer.parseInt("11" ,2);    // 2进制转成十进制打印出来
         System.out.println(i);
        System.out.println(i2);


        Integer a =1 ;       // 将基本类型转成对象  ，装箱
        a = a+1;             //自动拆箱  ，将对像变成集合。     如果对象为空，不能进行拆装箱

        big_test();
    }

    public static void big_test(){

        BigInteger big1 = new BigInteger("111111111111111333333333333333333333333333");
        System.out.println(big1);
        BigInteger big2 = new BigInteger("111111111111111333333333333333333333333333");

        //运算
        BigInteger he = big1.add(big2);

        BigInteger cha = big1.subtract(big2);

        BigInteger cheng = big1.multiply(big2);

        BigInteger chu = big1.divide(big2);


        //浮点大数据
        BigDecimal big_float1 = new BigDecimal("0.00000000009");
        BigDecimal big_float2 = new BigDecimal("0.0001111100000009");
        ///运算同上 ，关键是精度高

        //可能会有除不尽的方式   ， 所有有时候会报错 ，就是你要保留几位小数
        BigDecimal result = big_float1.divide(big_float2 , 2  ,BigDecimal.ROUND_DOWN);  //ROUND_DOWN截断
    }


}

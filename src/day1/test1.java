package day1;

/**
 * 1 ：基本类型
 *
 * 2 ：类型转换
 *       1：范围小的可以自动转为范围大的  byte 》 short 》int 》 long 》float 》double
 *       2：强制转换会丢数据         int i = （int) 2.222
 *
 *
 * 3:  ++  --
 * a++    是先赋值，再自增
 * ++a    是先自增，再赋值
 *
 * 4: 逻辑运算符
 *    &  一边是false ，全部是false
 *    |  一边是false ，全部是false
 *    ^  两边相同是false ，不同是True
 *    ！  取反
 *     && 短路与   一边是false  ，另一边不运行
 *     || 短路或  一边是true ，另一边不运行
 *
 *
 * 5：三元运算符
 *
 *      布尔表达式 ？  结果1 ：结果2 ；
 *
 * Created by Administrator on 2018\12\26 0026.
 */
public class test1 {
    //整型
     private byte b = 100;        //字节数 ：1    表示范围 -128 - 127
    int i = 100;         //字节数 ：4    表示范围
    short s = 100;      //字节数 ：2    表示范围
    long l = 100L;         //字节数 ：8    表示范围

    //浮点
    float f = 2.2F;        //字节数 ：4    表示范围 -128 - 127
    double d = 2.2;       //字节数 ：8    表示范围 -128 - 127

    //字符型
    char c = '高';          //字节数 ：2    表示范围 一个字符

    //布尔型
    boolean bl = true;         //字节数 ：1    表示范围 只有两个值

    String str = "haaahah";

    public static void main(String []args){
//        System.out.print();


        //3
        int i =5;
        int m = i++;
        System.out.print(i);  // 6
        System.out.print(m);  // 5

    }
}

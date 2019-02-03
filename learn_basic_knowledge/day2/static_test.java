package day2;

/**
 * 	被static修饰的成员变量属于类，不属于这个类的某个对象。
 * （也就是说，多个对象在访问或修改static修饰的成员变量时，其中一个对象将static成员变量值进行了修改，
 * 其他对象中的static成员变量值跟着改变，即多个对象共享同一个static成员变量）
 *
 * 	被static修饰的成员可以并且建议通过类名直接访问
 *
 * 	同一个类中，静态成员只能访问静态成员
 *
 *
 *开发中，我们想在类中定义一个静态常量，通常使用public static final修饰的变量来完成定义。
 * 此时变量名用全部大写，多个单词使用下划线连接。
 *
 *
 * 只要在方法中没有非静态方法，就要加上static
 * 成员变量，静态方法看左边  ， 运行非静态方法看右边   ！！！！！！
 *
 * 左 a = new 右（）；
 *
 *
 *
 * Created by Administrator on 2018/12/31 0031.
 */
public class static_test {
    private int a;
    private int b;
    public static void add(){
//        a++;   静态先于非静态实例化   ，所以静态先实例怎么调用非静态
     }

    public  void  add1(){

    }
}

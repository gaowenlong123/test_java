package day2;

/**
 * 继承的出现提高了代码的复用性，并方便开发。但随之也有问题，有些类在描述完之后，不想被继承，或者有些类中的部分方法功能是固定的，不想让子类重写。可是当子类继承了这些特殊类之后，就可以对其中的方法进行重写，那怎么解决呢？
 要解决上述的这些问题，需要使用到一个关键字final，final的意思为最终，不可变。
 final是个修饰符，它可以用来修饰类，类的成员，以及局部变量。


 1:  太监类	final修饰类不可以被继承，但是可以继承其他类
2:	final修饰的方法不可以被覆盖,但父类中没有被final修饰方法，子类覆盖后可以加final。
3:	final修饰的变量称为常量，这些变量只能赋值一次
4:  引用类型的变量值为对象地址值，地址值不能更改，但是地址内的对象属性值可以修改
5: 	修饰成员变量，需要在创建对象前赋值，否则报错。(当没有显式赋值时，多个构造方法的均需要为其赋值。)


 * Created by Administrator on 2018/12/31 0031.
 */
public final class final_test {

    //字段  成员变量
//    final int a;  必须赋值
    final int n;

    public final_test(int n){
        this.n = n;
    }


    public static void main(String[] args) {

        final test t1 =new test();
        test t2 = new test();

//        t1 =t2;   地址不可以改变



    }

}

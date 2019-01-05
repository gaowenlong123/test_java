package day1;

/**
 * 1: 封装
 *
 * 2: 继承
 *    父类的私有变量不可以访问
 *    不可以在静态区域访问非静态资源
 *    子类的权限 要大于等于 父类
 *    public protect default（不写就是它）  private
 *
 *
 * 3:多态
 *  父类  名称  = new  子类（）
 *  父类的对象会统一指向子类的方法
 *
 *  这个父类 可以是 类 也可以是 抽象类 也可以是接口
 *
 *  编译时看父类  ，运行在子类 ，即可以调用共有方法，而不能运行子类特殊方法）
 *  但是可以强制转型回来
 *
 *  子类 a = （子类）对象
 *
 * Created by Administrator on 2018\12\28 0028.
 */
public class test5 extends abstract_class implements inter_face{

    private int a;


    public static void main(String []args){
        test5 a = new test5();
        a.add();

//        a instanceof test5      对象a是不是 类test5的实例
    }

    public void add(){
//        System.out.print(super.c);

    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public int add2() {
        return 0;
    }


}



package day2;

/**
 *
 * 将类写在其他类的内部，可以写在其他类的成员位置和局部位置，
 * 这时写在其他类内部的类就称为内部类。其他类也称为外部类。
 *
 *成员内部类，定义在外部类中的成员位置。与类中的成员变量相似，可通过外部类对象进行访问
 * 外部类名.内部类名 变量名 = new 外部类名().new 内部类名();
 *
 *
 * 局部内部类，定义在外部类  方法  中的局部位置。与访问方法中的局部变量相似，可通过调用方法进行访问
 *
 *
 * 匿名内部类
 *    new 父类或接口(){
       //进行方法重写
       };

 * Created by Administrator on 2018/12/31 0031.
 */
public class inner_class extends static_test {

    int i = 1;
    public class inner{
        int i =2;
        public void say(){
            int i =3;
            System.out.print(i);    // i=3   就近原则
            System.out.print(this.i);   // i=2
            System.out.print(inner_class.this.i);  // i = 1
        }
    }

    public void out(){

        class jubu_class{
            public void say(){
                System.out.println("a");
            }
        }
        jubu_class  temp = new jubu_class();
        temp.say();
    }

    //匿名内部类


    public static void main(String[] args) {
        inner_class.inner a =new inner_class().new inner();

        //局部内部类
        new inner_class().out();


        new static_test(){           //实例化
            public void add1(){
                System.out.print("");  //重写方法
            }
        }.add1();           //调用子类方法

    }
}

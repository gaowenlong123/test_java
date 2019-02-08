package day17.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MyTest()
public class Demo {
    @MyTest
    private String aa;
   // @MyAnnotaion(age = 18,name = "zhangsan",values = {"AA","BB"},clz = String.class)
    @MyTest(name = "zhangsan")
    public void test1(){
        System.out.println("test1方法执行了.....");
    }

    @MyTest()
    public void test2(){
        System.out.println("test2方法执行了.....");
    }

    public void test3(){
        System.out.println("test3方法执行了.....");
    }
}

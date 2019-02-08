package day17;

@MyTestAnnotaion()
public class Demo {

    @MyTestAnnotaion
    private String aa;

    @MyTestAnnotaion(name = "zhangsan")
    public void test1(){
        System.out.println("test1方法执行了.....");
    }

    @MyTestAnnotaion()
    public void test2(){
        System.out.println("test2方法执行了.....");
    }

    public void test3(){
        System.out.println("test3方法执行了.....");
    }
}

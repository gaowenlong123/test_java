package day17.basic_annotation;

public class Cat extends  Animal{
    //重新父类方法
    @Override
    public void say() {

    }

//    写不要有移除这个变量的警告   。 因为变量没有被使用 ，鼠标在前面会有提示 ，移除这个变量
    @SuppressWarnings({"unused"})
    public static void main(String[] args) {
        int a = 10;
        int i = 10;
        test1();
    }

    /**
     * @Deprecated 方法已经过时，建立程序员不要用这个方法
     */
    @Deprecated
    public static void test1(){
        System.out.println("aaa");
    }
}



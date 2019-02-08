package day17;

public class Cat extends  Animal{
    //重新父类方法
    @Override
    public void say() {

    }

    //写main-psvm
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



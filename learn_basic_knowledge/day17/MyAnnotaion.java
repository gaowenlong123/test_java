package day17;

//自己声明一个注解
public @interface MyAnnotaion {//声明一个注解
    //声明成员
    int age() default 1;
    String name() default "gao";
    String[] values() default "";
    Class clz() default Object.class;
}


// @MyAnnotaion(age = 18,name = "zhangsan",values = {"AA","BB"},clz = String.class)
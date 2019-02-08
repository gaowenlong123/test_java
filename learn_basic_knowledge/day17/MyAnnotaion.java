package day17.annotation;

public @interface MyAnnotaion {//声明一个注解
    //声明成员
    int age() default 1;
    String name() default "gyf";
    String[] values() default "";
    Class clz() default Object.class;
}

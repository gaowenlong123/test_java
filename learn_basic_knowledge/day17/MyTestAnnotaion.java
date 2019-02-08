package day17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//声明在注解上的注解 就是元注解
//注解的生命周期    source .java文件     class 编译后文件(在编译后，就没有注解)      RUNTIME 运行在内存中
@Retention(RetentionPolicy.RUNTIME) //注解的一个策略 ， 保留在运行的时候
//@Target(ElementType.METHOD)//这个注解只能在方法上面用
//@Target(ElementType.FIELD)//这个注解只能在属性上面用
public @interface MyTestAnnotaion {
    String name() default "gao";
}

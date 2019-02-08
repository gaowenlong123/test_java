package day17.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解生存周期
//@Target(ElementType.METHOD)//这个注解只能在方法上面用
//@Target(ElementType.FIELD)//这个注解只能在属性上面用
public @interface MyTest {
    String name() default "gyf";
}

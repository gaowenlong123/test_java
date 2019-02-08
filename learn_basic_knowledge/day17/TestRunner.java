package day17;

import java.lang.reflect.Method;

/**
 * 注解的工作原理
 * 1.通过反射获取方法
 * 2.通过方法获取方法上面声明的注解对象
 * 3.通过注解对象可以获取注解声明一些参数
 * 4.通过反射来调用方法
 */

//模拟单元测试   运行注解类和被注解类
public class TestRunner {

    public static void main(String[] args)throws Exception {
        //执行Demo里单元测试两个方法
        //1.通过反射来获取 Demo里的所有方法
        Method[] methods = Demo.class.getMethods();

        for(Method m : methods){

            //只有以test开头的方法才是单元测试方法
            if(m.getName().startsWith("test")){

                //2.通过反射来获取方法上面的注解
                MyTestAnnotaion myTest = m.getAnnotation(MyTestAnnotaion.class);

                System.out.println(m.getName() + " 是否有MyTest注解:" + myTest);

                if(myTest != null){
                                                        //java给你简化的闭包。还是拿到注解的对象，需要执行
                    System.out.println("name=" + myTest.name());

                    //执行注解下面的方法
                    // 等于  m.invoke(new Demo())
                    m.invoke(Demo.class.newInstance());
                }
            }
        }


    }
}

package com.gao.factory;

import com.gao.aspect.MyAspect;
import com.gao.service.IUserService;
import com.gao.service.StudentService;
import com.gao.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    /**
     * 接口+ 实现类  使用这个框架
     *
     * JDK实现代理
     * controler要调用service ，这时候需要通过工厂类来调用 ，进行一次拦截
     *
     * @return
     */
    public static IUserService createUserService(){

        //内部类要访问外部的成员变量 ，外部成员变量 需要 有final
        //1.创建目标对象target
        final IUserService userService = new UserServiceImpl();

        //2.声明切面类对象
        final MyAspect aspect = new MyAspect();

        //3.把切面类2个方法 应用 目标类
        //3.1 创建JDK代理,拦截方法
        /*newProxyInstance(
                ClassLoader loader, 类加载器，写当类
                Class<?>[] interfaces, 接口,接口的方法会被拦截
                InvocationHandler h) 处理
                */

        IUserService seriviceProxy = (IUserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(), //当前工厂类的类加载器
                userService.getClass().getInterfaces(),// 想要被拦截的类
                new InvocationHandler() { //处理方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //开启事务
                        aspect.before();

                        //方法返回值是 业务方法的返回值
                        Object retObj = method.invoke(userService,args);
                        System.out.println("拦截返回值:" + retObj);

                        //提交事务
                        aspect.after();
                        return retObj;
                    }
                }
        );

        return seriviceProxy;
    }


    /**
     *
     *  不需要接口 只用实现类 用这个方法
     * cglib 字节码增强 实现代理 。 在运行时，创建目标类的子类 ， 从而对目标类进行增强
     * @return
     */
    public static StudentService createStudentService(){
        //1.创建目标对象target
        final StudentService studentService = new StudentService();

        //2.声明切面类对象
        final MyAspect aspect = new MyAspect();

        //3.创建增强对象
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(studentService.getClass());
        //设置回调【拦截】
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                /**
                 * proxy:
                 * proxy代理对象是StudentService的子类
                 */

                aspect.before();

                //放行方法
                // Object retObj = method.invoke(studentService,args);
                Object retObj = methodProxy.invokeSuper(proxy,args);//解藕  跟代理那个方法就没有关系了
                System.out.println("拦截.....");

                aspect.after();
                return retObj;
            }
        });

        //创建代理对象
        StudentService serviceProxy = (StudentService) enhancer.create();
        return serviceProxy;
    }
}

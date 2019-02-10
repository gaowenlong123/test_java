package Spring;

/**
 *
 * 1： 是一个轻量级的控制反转 （loC） 和面向切面的 （AOP）的容器框架
 * 不需要每次都new一个对象 ，把对象装进容器里 ，用哪个 拿哪个 。
 *
 *
 * 2：好处
 *          1：  方便解耦，简化开发    （spring 就是一个大工厂 ，专门负责生成Bean ，可以将所有对象创建和依赖关系维护由spring来管理
 *          2：  AoP编程    （  可以进行权限的拦截 ， 进行监控等功能 。声明式事务的支持 只需要通过配置就可以完成对事务的管理 ，无需手动编程）
 *          3：  方便单元测试
 *          4： 方便集成各种优秀的框架
 *          5： 降低javaEE API 的使用难度 （ 对一些难用的API例如 JDBC，javaMAil ，远程调用 进行了封装 ）
 *
 *
 * 3： 控制反转 ： 原本在程序中需要手动创建userservice对象的控制权 。 交由spring框架管理
 *
 *      DI 依赖注入  ： 在spring框架负责创建Bean对象时 ， 动态的将依赖对象注入到bean组件
 *
 *
 * 4： AOP 面向切面编程 ： 是函数式编程的一种衍生  。 
 *横向抽取机制   纵向抽取机制是继承 （耦合性高)  。 通过代理或者拦截的方式向目标类织入增强代码
 * ASpectJ是一个基于java语言的AOP框架
 *
 *
 * 5： AOP实现原理
 *      a:aop底层将采用代理机制进行实现
 *      b:接口+ 实现类 ： spring 采用JDK的 动态代理Proxy
 *      c:实现类 ：spring 采用 cglib字节码增强
 *
 *
 * 6： 术语:    target  目标类 :需要被代理的类。 例如： userservice
 *              Joinpoint(连接点） ： 所谓连接点是指那些可能被拦截到的方法 。 例如 ： 所以方法
 *              PointCut 切入点  ：已经被增强的连接点。 例如 ：addUser（）
 *              advice 通知/增强 ，增强代码；例如 ： after , before
 *              Weaving（织入） ：是指把增强advice应用到目标对象target 来创建新的代理对象proxy的过程
 *              proxy  代理类
 *              AspectJ （切面） ： 是 切入点pointcut 和通知 advice的结合 。 一个线是一个特殊的切面。
 *
 *
 *
 *
 *
 * Created by Administrator on 2019/2/9 0009.
 */
public class test_Spring {
}

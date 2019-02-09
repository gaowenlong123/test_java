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
 * Created by Administrator on 2019/2/9 0009.
 */
public class test_Spring {
}

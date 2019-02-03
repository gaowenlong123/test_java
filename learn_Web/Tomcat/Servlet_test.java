package Tomcat;

/**
 * 1： servlet 就是处理一个请求
 *
 * 浏览器 发出一个请求 ，找到tomcat项目 ， 在根据该项目下面的web.xml找到 对应的servlet
 * 再调用该servlet的实现类的方法， 将结果返回给客户端
 *
 *
 * 2： 实现的三种方式
 *
 *      1： 实现 Servlet 接口     （少用的）
 *      2： 继承 GenericServlet （适配器模式 ： 只想用其中一部分的方法 ）
 *      3： 继承 HttpServlet （ 模板设计模式 ： 工作中常用的 ）
 *
 *
 * Created by Administrator on 2019/2/4 0004.
 */
public class Servlet_test {
}

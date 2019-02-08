package Tomcat;

/**
 *
 * 1： 用来监听常见的web域对象  request ， session servletContext   （没有过滤器常用）
 *
 * 2：监听器的作用 ： 监听web对象创建与销毁
 *                    监听web对象的属性变化
 *                    监听session绑定javaBean操作
 *
 *  3： 监听器的使用步骤
 *
 *                  1： 创建一个类 ， 实现指定的监听接口
 *                  2：重写接口的方法
 *                  3： 在web.xml中配置监听
 *
 *  4：监听session绑定javaBean操作 ，不需要再web.xml中注册 。 只要在javaBean类中继承接口，是实现该类
 * Created by Administrator on 2019/2/8 0008.
 */
public class test_listener {
}

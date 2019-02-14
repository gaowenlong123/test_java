package Spring_MVC;

/**
 *
 * 1：springMVC 是一个强大而且灵活的web框架 。借助注解 ，springMVC 怎么把页面的数据在控制器中接收就行
 *
 *   请求 --> DispatcherServlet -->BeanNameUrlHandlerMapping(寻找Controller) -
 *
 *          -> SimpleControllerHandlerAdapter(执行控制器，返回modelAndView)  -
 *          -> InternalResourceViewResolver(查找jsp路径） -
 *          ->  响应
 *
 *   由上可知springMVC 是有  DispatcherServlet ，处理器映射【找控制器】 ， 适配器【调用控制器方法】
 *                                             ，控制器【业务】 ，视图解析器【自动拼接前后缀】 ，视图 组成
 *
 *
 * 2：  Struts参数 ：基于属性封装，在action会添加属性 ，提供set方法
 *      SpringMVC 参数封装 : 基于方法进行封装 ，参数写在方法中
 *
 *
 * 3： SpringMVC 与 Struts 的区别 ：
 *                  structs是基于过滤器实现的  。 多例的
 *                  springMVC 是基于 servlet 实现的 ，比过滤器快。 单例的  （快）
 *
 *                  structs是基于属性的封装
 *                  springMVC是基于方法的封装
 *
 *
 *4 ： springMVC 多视图  : 就是可以返回json 也可以返回xml
 *      第一步：导包   spring-oxm-4.2.0.RELEASE.jar
 *      第二步：配置多视图    。 转json用谁 ，转xml用哪个类处理
 *
 *
 *
 *
 *
 */
public class test {
}

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
 */
public class test {
}

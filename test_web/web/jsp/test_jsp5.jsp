<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    /* 九大内置对象  ，不用new 直接可以拿来用
     * pageContext 重要   ：域对象
     * 可以操作其他三个域对象 （request： 在同一个请求对象，才有效【只有转发才能共享】
      *                         session：在同一个浏览器同一个session才有效
       *                        applcation （等同于servletContext ，只是前者是在jsp的名称 ，后者是servlet中的名称 。 整个应用都可以共享）
      */


    //往作用域 存值          名字         值       范围
    //void setAttribute(String name,Object o，int Scope);
    //pageContext.setAttribute("p1", "gyf-page", PageContext.PAGE_SCOPE);
    //pageContext.setAttribute("p2", "gyf-request", PageContext.REQUEST_SCOPE);
    //pageContext.setAttribute("p3", "gyf-session", PageContext.SESSION_SCOPE);
    //pageContext.setAttribute("p4", "gyf-applicatoin", PageContext.APPLICATION_SCOPE);

    //从作用域 取值
    //out.write((String)pageContext.getAttribute("p4", PageContext.APPLICATION_SCOPE));


	/* findAttribute(String name); 方法
	自动从page request session application依次查找，找到了就取值，结束查找。 */
    /*page 当前servlet的实例*/

	/* 例如 */
    //pageContext.setAttribute("p", "gyf-page", PageContext.PAGE_SCOPE);
    pageContext.setAttribute("p", "gyf-request", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("p", "gyf-session", PageContext.SESSION_SCOPE);
    //pageContext.setAttribute("p", "gyf-applicatoin", PageContext.APPLICATION_SCOPE);

    out.write((String)pageContext.findAttribute("p"));
%>
</body>
</html>

<%@ page import="com.gao.model.Person" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/8 0008
  Time: 下午 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

session和对象进行绑定
<%
    //1.创建person对象
    Person p = new Person("泽东","毛");

    //2.把对象存在session中，相当把p与session进行绑定
    request.getSession().setAttribute("p", p);
%>



<br>
往servletContext存、修改、移除数据
<%
    request.getServletContext().setAttribute("name", "毛主席");
    request.getServletContext().setAttribute("name", "刘少奇");
    request.getServletContext().removeAttribute("name");
%>



<br>
session和对象解绑
<%
    //解绑【两种方式可以解绑】
    //request.getSession().invalidate(); 把session和对象进行解除绑定了就是解除绑定了
    request.getSession().removeAttribute("p");
%>


<br>
销毁session
<%
    request.getSession().invalidate();
%>


</body>
</html>

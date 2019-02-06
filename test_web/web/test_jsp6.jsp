<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.可以通过pageContext获取其它8个内置对象   一般用 requrest session的比较多 ， 因为page只在当前页面有效 ，application是全局作用域
    //request = pageContext.getRequest();
    //response = pageContext.getResponse();
    //page = pageContext.getPage(), this
    //config = pageContext.getServletConfig()
    //out = pageContext.getOut()
    //session = pageContext.getSession();
    //.......

    //2.往session存值，当第一种方式方便
    //session.setAttribute("name", "gyf");
    //pageContext.getSession().setAttribute("name", "fff");
    //pageContext.forward("login.jsp");//转发

    //3.转发方式的总结
    //	1.在Servlet中进行转发 request.getRequestDispatcher("/Lesson3Servlet2").forward(request, response);
    //	2.<jsp:forward page=""></jsp:forward> jsp标签
    //	3.pageContext.forward("login.jsp"); 内置对象

    //4.page与pageContext的关系 相等
    //往page存数据
//    pageContext.setAttribute("p1", "sss",PageContext.APPLICATION_SCOPE);
    /* 没有指定范围 默认存在pageContext*/
    pageContext.setAttribute("p1", "sss");
    out.write((String)pageContext.getAttribute("p1",PageContext.PAGE_SCOPE));
%>
</body>
</html>

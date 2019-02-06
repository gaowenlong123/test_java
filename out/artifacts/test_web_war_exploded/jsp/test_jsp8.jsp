<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- EL的隐式对象 --%>

<%
    //pageContext:是JSP的内置对象
    //1.存数据
    pageContext.setAttribute("p1", "gyf-page", PageContext.PAGE_SCOPE);
    pageContext.setAttribute("p2", "gyf-request", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("p3", "gyf-session", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("p4", "gyf-applicatoin", PageContext.APPLICATION_SCOPE);

    //2.取值
    //pageContext.getAttribute(arg0)
    //pageContext.findAttribute(arg0)
    //pageContext.getRequest()
%>

<br>-------------------------------------------------------------------------------<br>
<!-- 通过EL表达式从指定的四个作用域来取值 -->
${pageScope.p1}<br>
${requestScope.p2}<br>
${sessionScope.p3}<br>
${applicationScope.p4}<br>

<br>-------------------------------------------------------------------------------<br>
<!-- 通过EL表达式获取上下文路径【项目名称】
	  作用：灵活设置Servlet的访问路径
 -->
项目名称：${pageContext.request.contextPath}<br>

<br>-------------------------------------------------------------------------------<br>
<!-- 通过EL表达式获取请求参数 -->
<br>通过EL表达式获取请求参数<br>
${param['username'] }<br>
${param['password'] }<br>


<br>-------------------------------------------------------------------------------<br>
<!-- 通过EL表达式获取请求头数据 -->
<br>通过EL表达式获取请求头数据<br>
${header['Accept']}


<br>-------------------------------------------------------------------------------<br>
<br>通过EL表达式获取Cookie的数据<br>
${cookie['JSESSIONID'].value}<br>

<br>-------------------------------------------------------------------------------<br>
<br>通过EL表达式设置Cookie的数据<br>
<%
    Cookie ck = new Cookie("name","hhhhhh");
    ck.setMaxAge(60 *60);
    response.addCookie(ck);
%>
${cookie['name'].value}<br>
</body>
</html>

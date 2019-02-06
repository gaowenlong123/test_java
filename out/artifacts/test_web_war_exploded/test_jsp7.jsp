<%@ page import="com.gao.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.gao.model.Address" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--

	EL表达式：
	1.EL表达式是用来 获取 4大作用域数据
	2.它是用来简化java代码

	3.EL的使用方法 ${作用域的key.属性名}
	  ${user.username},实现是调用user对象的getUsername方法

	//1.jsp往request存数据
--%>

<!-- 1.el的基本使用 -->
<%
    User user = new User("习大大","123","男");
    user.setAddress(new Address("中国","陕西"));

    //把Key放在作用域中
    request.setAttribute("user", user);
%>
显示数据:<br>
<%--原始显示--%>
<%-- <%=user.getUsername()%><br>
<%=user.getPassword()%><br>
<%=user.getGender()%><br> --%>

<%--改进后显示数据--%>
名字：${user.username} ----- ${user['username']} -- ${user["username"]}<br>
密码：${user.password}<br>
性别：${user.gender}<br>
国家：${user.address.country}<br>
城市：${user.address.city}<br>


-------------------------------------------------------------------------------<br>
<!-- 2. empty空 知识
	 如果是集合是null,或者是集合没有元素，都返回true
-->
<%
    List<String> list1 = null;
    List<String> list2 = new ArrayList<String>();
    //list2.add("gyf");

    request.setAttribute("list1", list1);
    request.setAttribute("list2", list2);
    request.setAttribute("str1", null);
    request.setAttribute("str2", "习大");
%>
list1是否为空 ${empty list1}<br>
list2是否为空 ${empty list2}<br>

str1是否为空 ${empty str1}<br>
str2是否为空 ${empty str2}<br>


-------------------------------------------------------------------------------<br>
<!-- 3.集合数据获取 List&Map
	list通过下标取${names[0]}
-->
<%
    List<String> names = new ArrayList<String>();
    names.add("mayun");
    names.add("mht");
    names.add("gyf");
    request.setAttribute("names", names);

    Map<String,String> company = new HashMap<String,String>();
    company.put("name","三亚公司");
    company.put("address","广州");
    request.setAttribute("company", company);
%>


${names[0]}<br>
${names[1]}<br>
${names[2]}<br>

${company['name']}<br>
${company['address']}<br>



-------------------------------------------------------------------------------<br>
<!-- 4.三元运算符 -->
<%
    //存性别 0:男 1：女
    request.setAttribute("gender", 1);
%>
性别:
<input type="radio" ${gender == 1 ? "checked='checked'" : ""}>女
<input type="radio" ${gender == 0 ? "checked='checked'" : ""}>男


<br>-------------------------------------------------------------------------------<br>
<!-- 5.+=*/ -->
<%
    request.setAttribute("a", 10);
    request.setAttribute("b", 2);
    request.setAttribute("c", 3);
    request.setAttribute("d", 2);
%>

${(a + b * c)/ d}
</body>
</html>

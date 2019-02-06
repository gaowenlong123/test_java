<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/6 0006
  Time: 下午 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSTL:JSP标签库的使用
	使用步骤:
		1.导入JSTL的jar包，然后再jsp页面顶部导入JSTL标签库
		2.在jsp中可以使用c:形式使用标签
 --%>


<!-- 一：通用标签: set、 out、 remove - 用于操作作用域数据
	set:存一个变量值
	out:取值
	remove:从作用域移除变量
-->

<br>-------------------------------------------------------------------------------<br>
存num数据:<c:set  var="num" value="${5+3}" scope="page" ></c:set><br>
取出num数据:<c:out value="${num}"></c:out><br>
移除num数据:<c:remove var="num"/><br>
再次取出num数据:<c:out value="${num}" default="0"></c:out>



<br>-------------------------------------------------------------------------------<br>
<!-- 二：条件标签: if choose
	   1.test属性中写EL表达式
	   2.choose内部与when一起使用，相当switch
-->
<br>
<c:set  var="a" value="6"></c:set>
<c:if test="${ a > 5 }">
    a的值大于5
</c:if>


<br>-------------------------------------------------------------------------------<br>
<!-- b的值 1：春 2:夏 3：秋 4:冬 -->
<c:set  var="b" value="4"></c:set>
<c:choose>
    <c:when test="${b == 1 }">
        春天来了
    </c:when>
    <c:when test="${b == 2 }">
        夏天来了
    </c:when>
    <c:when test="${b == 3 }">
        秋天来了
    </c:when>
    <c:when test="${b == 4 }">
        冬天来了
    </c:when>
</c:choose>


<br>-------------------------------------------------------------------------------<br>
<!-- 三、迭代标签foreach -->
<br>
<c:forEach var="i" begin="1" end="10" step="3">
    ${i}<br>
</c:forEach>
</body>
</html>

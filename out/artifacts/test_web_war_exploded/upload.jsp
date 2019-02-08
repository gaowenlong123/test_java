<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/8 0008
  Time: 下午 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function addFileUploadDiv(){
            //1.通过id拿到filesDiv
            var div = document.getElementById('filesDiv');
            div.innerHTML += '<div>文件:<input type="file" name="file"><input type="button" value="删除" onclick="deleteDiv(this)"></div>'
        }

        function deleteDiv(input) {
            //alert("xxx");
            //通过父标签移除子标签
            var div = document.getElementById('filesDiv');
            div.removeChild(input.parentNode);
        }
    </script>
</head>
<body>
                                                                                        <%--表单提交的类型 ： 这个类型分段上传--%>
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    文件:<input type="file" name="file"><br>
    <input type="submit">
</form>



<br>-----------------------------------------------------<br>
动态多文件上传
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    文件1:<input type="file" name="file"><br>
    文件2:<input type="file" name="file"><br>
    文件3:<input type="file" name="file"><br>
    <input type="submit">
</form>



<br>-----------------------------------------------------<br>
js多文件上传
<form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <div id="filesDiv">
        <div>文件:<input type="file" name="file"><input type="button" value="删除" onclick="deleteDiv(this)"></div>
    </div>
    <input type="button" value="添加" onclick="addFileUploadDiv()">
    <input type="submit">
</form>


</body>
</html>

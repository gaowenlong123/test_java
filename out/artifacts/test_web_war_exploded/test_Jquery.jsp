<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">

        //onload文档加载完毕再调用js函数
        /* window.onload = function () {
         var divTag = document.getElementById('div1');
         divTag.innerHTML = "你好。很高兴认你！";
         } */

        //jquery文档就绪函数 $(function(){});
         $(function() {
         var divTag = document.getElementById('div1');
         divTag.innerHTML = "你好。很高兴认你1！";
         });


        //常用的是上面一种
     /*   $(document).ready(function () {
            var divTag = document.getElementById('div1');
            divTag.innerHTML = "你好。很高兴认你！";
        });*/

    </script>
</head>
<body>
<div id="div1"></div>
</body>
</html>

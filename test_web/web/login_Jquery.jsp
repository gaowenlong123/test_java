<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
    <title>Title</title>
    <script type="text/javascript">
        $(function() {
            //1.按钮绑定事件
            $('#loginBtn').click(function() {

                //2.获取表单的数据
                var username = $("#username").val();
                var password = $("#password").val();

                //3.封装表单数据 username=gyf&password=123
                //封装成对象
                var params = {"username":username,"password":password};
                console.log(params);

                //4.get请求
                var url = '${pageContext.request.contextPath}/LoginServlet_ajax';

                //get请求
                //如果写了json,会把服务的数据直接转成json对象
                //data服务器返回的数据 。访问成功后 ，就会把数据存在data中
                $.get(url,params,function(data){

                    console.log(data);
                    if(data.success == 1){//成功
                        $('#tip').text('登录成功');
                    }else{
                        $('#tip').text(data.errMsg);
                    }
                },'json');

                /* $.get(url,params,function(data){
                 //data服务器返回的数据
                 console.log(data);
                 //把data转成对象
                 var result = JSON.parse(data);
                 if(result.success == 1){//成功
                 $('#tip').text('登录成功');
                 }else{
                 $('#tip').text(result.errMsg);
                 }
                 },'text'); */
            });
        });

        //post登录
        $(function() {
            //1.按钮绑定事件
            $('#loginBtn1').click(function() {

                //2.获取表单的数据
                var username = $("#username1").val();
                var password = $("#password1").val();

                //3.封装表单数据 username=gyf&password=123
                //封装成对象
                var params = {"username":username,"password":password};
                console.log(params);

                //4.post请求
                var url = '${pageContext.request.contextPath}/LoginServlet_ajax';

                $.post(url,params,function(data){
                    //如果写了json,会把服务的数据直接转成json对象
                    //data服务器返回的数据
                    console.log(data + '---');
                    if(data.success == 1){//成功
                        $('#tip').text('登录成功');
                    }else{
                        $('#tip').text(data.errMsg);
                    }
                },'json');
            });
        });

        $(function() {
            //该方法只有form的时候好用
            $('#loginBtn2').click(function() {
                var url = '${pageContext.request.contextPath}/LoginServlet_ajax';

                //6666666
                var params = $('form').serialize();//转成username=gyf&password=123

                $.post(url,params,function(data){
                    //如果写了json,会把服务的数据直接转成json对象
                    //data服务器返回的数据
                    console.log(data + '---');
                    if(data.success == 1){//成功
                        $('#tip').text('登录成功');
                    }else{
                        $('#tip').text(data.errMsg);
                    }
                },'json');
            });
        });


    </script>
</head>
<body>
<span style="color: red" id="tip"></span>
<form>
    <%--只有form的时候好用 --%>
    用户名: <input type="text" name="username" id="username2"><br>
    密码:<input type="password" name="password" id="password2"><br>
    <input type="button" value="直接拿form数据登录" id='loginBtn2'>
</form>

<form>
    用户名: <input type="text" name="username" id="username"><br>
    密码:<input type="password" name="password" id="password"><br>
    <input type="button" value="get登录" id='loginBtn'>
</form>

<form>
    用户名: <input type="text" name="username" id="username1"><br>
    密码:<input type="password" name="password" id="password1"><br>
    <input type="button" value="post登录" id='loginBtn1'>
</form>


</body>
</html>

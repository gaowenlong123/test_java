<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/7 0007
  Time: 下午 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        //js的get登录方法
        function login_get() {
            //使用ajax往servlet发送get请求
            //1.获取表单的数据
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;

            //2.拼接表单数据
            var params = 'username=' + username + '&password=' + password;
            console.log(params);

            //3.url
            var url = '${pageContext.request.contextPath}/LoginServlet_ajax?' + params;
            console.log(url);

            //4.使用ajax发送get请求
            //4.1 创建一个请求对象
            var request = new XMLHttpRequest();

            //4.2 调用 get请求的方法
            //调用open方法的时候，都用异步,true
            request.open('get',url,true);
            request.send();


            //4.3 接收服务的响应
            /*
            readyState准备状态码 ： 0 请求未初始化
                                    1 服务器建立连接
                                    2 请求已接收
                                    3 请求处理中
                                    4 请求已完成 ，响应已就绪
            * */
            request.onreadystatechange = function(){
                console.log('准备状态码-' + request.readyState + ' : 响应状态码-' + request.status);

                if(request.readyState == 4 && request.status == 200){

                    //接收服务器响应的数据   servlet 的输出  response.getWriter().write("success"); 。 而没有输出页面
                    var rspText = request.responseText;
                    console.log(rspText);

                    //获取span标签
                    var tipTag = document.getElementById('tip');
                    if(rspText == 'success'){
                        tipTag.innerHTML = '登录成功 ';
                    }else{
                        tipTag.innerHTML = '登录失败';
                    }
                }
            }
        }

        //js的登录方法
        function login_post() {
            //使用ajax往servlet发送post请求
            //1.获取表单的数据
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;

            //2.拼接表单数据
            var params = 'username=' + username + '&password=' + password;
            console.log(params);

            //3.url
            var url = '${pageContext.request.contextPath}/LoginServlet_ajax';
            console.log(url);

            //4.使用ajax发送get请求
            //4.1 创建一个请求对象
            var request = new XMLHttpRequest();



            //4.2 调用 post请求的方法
            //调用open方法的时候，都用异步,true
            request.open('post',url,true);

            // 设置post的请求头
            request.setRequestHeader('content-type','application/x-www-form-urlencoded');
            //把参数扔到这里面
            request.send(params);

            //4.3 接收服务的响应
            request.onreadystatechange = function(){
                console.log('准备状态码-' + request.readyState + ' : 响应状态码-' + request.status);

                if(request.readyState == 4 && request.status == 200){
                    //接收服务器响应的数据
                    var rspText = request.responseText;
                    console.log(rspText);

                    //获取span标签
                    var tipTag = document.getElementById('tip');
                    if(rspText == 'success'){
                        tipTag.innerHTML = '登录成功 ';
                    }else{
                        tipTag.innerHTML = '登录失败';
                    }
                }
            }
        }

        function test_json(){
            //1.json字符串转成对象【取值方便】
            console.log('1.json字符串转成对象');
            var str1 = '{"firstName":"yongfeng","lastName":"guo"}';
            console.log('str1:' + str1);

            var jsonObj = JSON.parse(str1);//把字符串转成对象

            //通过调用对象的属性获取值
            console.log('jsonObj1:' + jsonObj); //jsonObj1:[object Object]
            console.log(jsonObj.firstName);
            console.log(jsonObj.lastName);

            //2.把对象转成json字符串
            console.log('2.把对象转成json字符串');
            var str2 =  JSON.stringify(jsonObj);
            console.log('str2:' + str2);


            //3.json
            console.log('3遍历数组');
            var str3 = '[{"firstName":"yongfeng","lastName":"guo"},{"firstName":"Bill","lastName":"Gates"},{"firstName":"Steve","lastName":"Thomes"}]'
            //把字符串转成对象数组
            var persons = JSON.parse(str3);
            for (var i = 0; i < persons.length; i++) {
                var p = persons[i];
                console.log(p.lastName + '-' + p.firstName);
            }
            console.log(persons);
        }

        //json的登录方法
        function login() {
            //使用ajax往servlet发送get请求
            //1.获取表单的数据
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;

            //2.拼接表单数据
            var params = 'username=' + username + '&password=' + password;
            console.log(params);

            //如果是写是纯js的代码话，最好要对get请求参数进行url编码 。
            //对参数url编码
            params = encodeURI(params);//解码 decodeURI

            //3.url
            var url = '${pageContext.request.contextPath}/LoginServlet_ajax?' + params;
            console.log(url);

            //url = encodeURIComponent(url); 这个方法会把特殊符号也转成 %形式   。推荐这
            //4.使用ajax发送get请求
            //4.1 创建一个请求对象
            var request;

            //兼容老的浏览器
            if (window.XMLHttpRequest)
            {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                request=new XMLHttpRequest();
                alert("当前的浏览器有XMLHttpRequest对象");
            }else{
                // IE6, IE5 浏览器执行代码
                request=new ActiveXObject("Microsoft.XMLHTTP");
                alert("当前的浏览器没有XMLHttpRequest对象，只有ActiveXObject");
            }

            //4.2 调用 get请求的方法
            //调用open方法的时候，都用异步,true
            request.open('get',url,true);
            request.send();

            //4.3 接收服务的响应
            request.onreadystatechange = function(){
                console.log('准备状态码-' + request.readyState + ' : 响应状态码-' + request.status);

                if(request.readyState == 4 && request.status == 200){
                    //接收服务器响应的数据
                    var rspText = request.responseText;
                    console.log(rspText);

                    // 把数据转成json对象
                    var jsonObj = JSON.parse(rspText);

                    //获取span标签
                    var tipTag = document.getElementById('tip');
                    if(jsonObj.success == 1){
                        tipTag.innerHTML = '登录成功 ';
                    }else{
                        tipTag.innerHTML = jsonObj.errMsg;
                    }
                }
            }
        }

        //json的登录方法
        function login_post() {

        }

    </script>
</head>
<body>

<span style="color: red" id="tip"></span>
<form>
    用户名: <input type="text" name="username" id="username"><br>
    密码:<input type="password" name="password" id="password"><br>
    <input type="button" value="登录" onclick="login()">

</form>
<br><br>
测试json<input type="button" value="json" onclick="test_json()">
</body>
</html>

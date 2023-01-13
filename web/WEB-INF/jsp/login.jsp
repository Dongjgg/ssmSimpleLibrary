<%--
  Created by IntelliJ IDEA.
  User: Dj
  Date: 2023/1/12
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Login</title>

    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
    <link href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>


    <!--为了保险起见，导入了本地的jquery和fontawesome    -->
    <!--jquery-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.6.3.js" ></script>
    <link rel="stylesheet" href="css/Login.css">

    <style>
        .form {
            background: rgba(255,255,255,0.9);
            width:400px;margin:50px auto;
        }
        /*设置字体和大小*/
        label {
            font-family: Arial;font-size: 15px
        }
        /*当输入正确时,给输入框设置浅绿色*/
        input.form-control:valid{
            background-color: mintcream;
        }
        /*当输入正确前,给输入框设置浅红色#ffeeed*/
        input.form-control:invalid{
            background-color: white;
        }
        /*设置图标为行内元素，并设置大小和颜色*/
        .fa{
            display: inline-block;
            top: 27px;
            left: 6px;
            position: relative;
            color: #575757;
        }
        /*为几个输入框设置padding,防止和图标重合*/
        input[type="text"],input[type="password"],input[type="email"]{
            padding-left:26px;
        }
        .form-title{
            padding-top:20px;
        }
        #button{
            padding-bottom: 50px;
        }
    </style>


</head>
<body>
<div class="container">
    <div class="form row">
        <form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal col-sm-offset-3 col-md-offset-3">
            <h3 class="form-title">登录</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <!--        用户名图标和用户名输入框            -->
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input class="form-control" type="text" name="username" id="username" placeholder="请输入用户名" required>
                </div>
                <!--        密码图标和密码输入框                -->
                <div class="form-group">
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <input class="form-control " type="password" name="password" id="password" placeholder="请输入密码" required>
                </div>
                <div class="form-group">
                    <input type="submit" value="登录" class="btn btn-success pull-right">
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>


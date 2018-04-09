<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  </head>
  
  <body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<a class="navbar-brand  disabled" href="#">一  卡  通  系  统 </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="row  container-fluid">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

    <div class="navbar-nav col-sm-10 row">
      <a class="nav-item nav-link active  ml-3" href="<%=basePath %>stuLogin/firstPage">首页 <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="#">贫困生预测</a>
  </div>
  <div class="col-sm-2 row">
       <a class="nav-item nav-link" href="<%=basePath %>stuLogin/login"><font color="#ffffff">登录</font></a>
	   <a class="nav-item nav-link" href="<%=basePath %>stuLogin/logout"><font color="#ffffff">登出</font></a>
      </div>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <h1 class="display-4" align="center">请先登录</h1>
		<form id="teacherLogin" action="teacherLogin/login" method="post">
			<div class="input-group">
				<span class="input-group-addon">账&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号:</span> 
				<input type="text" class="form-control"  name="id">
			</div>
			<div class="input-group">
				<span class="input-group-addon">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码:</span>
				<input type="password"  name="password" class="form-control" >
			</div>
			<hr class="my-4">
			<p>若无账号，请联系一卡通小组（wcmc@csu.edu.cn）</p><br>
			<p><a href="login.jsp">学生登陆</a></p>
			<p class="lead">
			<div align="center">
				<input type="submit" value="登录" class="btn btn-dark btn-lg" href="#" role="button">
				
			</div>
		</form>
</div>
   
   	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>

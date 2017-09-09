<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="wcmc.schoolcard.dto.Webxs"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>starting page</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand  disabled" href="#">一 卡 通 系 统 </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="row  container-fluid">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">

			<div class="navbar-nav col-sm-10 row">
				<a class="nav-item nav-link active ml-3"
					href="<%=basePath%>stuLogin/firstPage">首页 <span class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link" href="<%=basePath%>stuLogin/bookRec">推荐系統</a>
				<a class="nav-item nav-link" href="#">贫困生预测</a>
			</div>
			<div class="col-sm-2 row">
				<a class="nav-item nav-link" href="<%=basePath%>stuLogin/login"><font
					color="#ffffff">登录</font> </a> <a class="nav-item nav-link"
					href="<%=basePath%>stuLogin/logout"><font color="#ffffff">登出</font>
				</a>
			</div>
		</div>
	</div>
	</nav>

	<!-- 获取session中的值 -->
	<%
		Webxs xs = (Webxs) session.getAttribute("xs");
		String name = xs.getXm();
		String gender = xs.getXbdm();
		String faculty = xs.getYxshmc();
		String nation = xs.getMzmc();
		String major = xs.getZyhmc();
		String className = xs.getBjmc();
		String grade = xs.getSznj();
	%>

	<div class="container-fluid">
		<div class="row">
			<div class="card  col-3 border border-dark"
				style="background-color: #0f0f0f">
				<img src="<c:url value="/resources/img/test.jpg"/>" alt="词云" class="card-img-top">
				<div class="card-body">
					<h4 align="center">
						<font color="white"><%=name%></font>
					</h4>
					<div class="container-fluid">
						<div class="row">
							<div class="col-6" style="color: white;">
								性别：<%=gender%></div>
							<div class="col-6" style="color: white;">
								民族：<%=nation%></div>
						</div>
						<div class="row">
							<div class="col-6" style="color: white;">
								年级：<%=grade%></div>
							<div class="col-6" style="color: white;">
								班级：<%=className%></div>
						</div>
						<div class="row">
							<div class="col" style="color: white;">
								院系：<%=faculty%></div>
						</div>
						<div class="row">
							<div class="col" style="color: white;">
								专业：<%=major%></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-9">
				<div class="row">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel"  style="height:50%;width:100%">
						<div class="carousel-inner" style="height:100%;width:100%">
							<div class="carousel-item active">
								<img class="d-block w-100" src="<c:url value="/resources/img/Sale.jpg"/>" alt="First slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="<c:url value="/resources/img/test.jpg"/>" alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100" src="<c:url value="/resources/img/zhengqingchun.jpg"/>" alt="Third slide">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span> </a> <a class="carousel-control-next"
							href="#carouselExampleControls" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span> </a>
					</div>
				</div>
				<div class="row">
					<table class="table">
						<tbody>
							<tr>
								<th scope="row" bgcolor="#000000"><font color="white">本年度热书</font></th>
							</tr>
							<tr>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="row">
					<table class="table">
						<tbody>
							<tr>
								<th scope="row" class="rounded" bgcolor="#000000" ><font color="white">统计界面展示</font></th>
							</tr>
							<tr>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
						</tbody>
					</table>
				</div>
								
			</div>
		</div>
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> 
	<div class="row  container-fluid" align="center">
		<div class="col" style="color: white">中南大学无线计算网络组</div>
	</div>
	<div class="row  container-fluid" align="center">
		<div class="col" style="color: white">@wcmc.csu.edu.cn</div>
	</div>
	<div class="row  container-fluid" align="center">
		<div class="col" style="color: white">版权归计算组所有</div>
	</div>
	</nav>


	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>

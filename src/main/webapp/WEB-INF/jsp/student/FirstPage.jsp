<%@page import="wcmc.schoolcard.dto.Webxs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ResourceBundle nginx = ResourceBundle.getBundle("nginx");
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">

<title>starting page</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- <link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous"> 
	 -->
<!-- css 文件 -->
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/foundation/5.5.3/css/foundation.min.css">

<!-- jQuery 库 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/foundation/5.5.3/js/foundation.min.js"></script>

<!-- modernizr.js 文件 -->
<script src="http://cdn.static.runoob.com/libs/foundation/5.5.3/js/vendor/modernizr.js"></script>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
<script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1/jquery-3.2.1.js"/>"></script>


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
			<!-- 
				<a class="nav-item nav-link active ml-3"
					href="<%=basePath%>stuLogin/firstPage">首页 <span class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link" href="<%=basePath%>stuLogin/bookRec">推荐系統</a>
				<a class="nav-item nav-link" href="#">贫困生预测</a>
			-->
				<ul class="tabs" data-tab="">
				  <li class="tab-title active"><a href="<%=basePath%>stuLogin/firstPage" aria-selected="false" tabindex="0">主页</a></li>
				  <li class="tab-title"><a href="#menu1" aria-selected="false" tabindex="-1">消费情况</a></li>
				  <li class="tab-title"><a href="#menu2" aria-selected="true" tabindex="-1">成绩预警</a></li>
				  <li class="tab-title"><a href="#menu3" aria-selected="false" tabindex="-1">推荐系统</a></li>
				</ul>
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
	
	<div class="container-fluid">
		<div class="row">
			<div class="card  col-3 border border-dark"
				style="background-color: #0f0f0f">
				<!-- <img src="<%=nginx.getString("wordcloud")%>${sessionScope.imgId}" onerror="javascript:this.src='<c:url value="/resources/img/error.bmp"/>'" alt="词云" class="card-img-top" src='<c:url value="/resources/img/error.bmp"/>'>
				 -->
				<div class="card-body">
					<h4 align="center">
						<font color="white">${sessionScope.xs.xm }</font>
					</h4>
					<div class="container-fluid">
						<div class="row">
							<div class="col-6" style="color: white;">
								性别：${sessionScope.xs.xbdm==1?'男':'女' }</div>
							<div class="col-6" style="color: white;">
								民族：${sessionScope.xs.mzmc }</div>
						</div>
						<div class="row">
							<div class="col-6" style="color: white;">
								年级：${sessionScope.xs.sznj }</div>
							<div class="col-6" style="color: white;">
								班级：${sessionScope.xs.bjmc }</div>
						</div>
						<div class="row">
							<div class="col" style="color: white;">
								院系：${sessionScope.xs.yxshmc }</div>
						</div>
						<div class="row">
							<div class="col" style="color: white;">
								专业：${sessionScope.xs.zyhmc }</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tabs-content">
				  <div class="content active" id="home" aria-hidden="false" tabindex="-1">
				  	<div>
					    <h3>个人首页</h3>
					    <div id="personalGraph" style="width:800px;height: 400px;">
					    </div>
					    <script class="personalGraph">
					    	var myChart = echarts.init(document.getElementById('personalGraph'));
					    	var result = ${sessionScope.personalGraph};
				    		var option = {
			    			    title: {
			    			        text: '学生画像'
					    		},
					    		tooltip: {},
					    		legend: {
					    			data: ['平均水平（Average）', '学生实际水平（Actual）']
					    		},
					    		radar: {
					    			name: {
					    				textStyle: {
					    			    	color: '#fff',
					    			        backgroundColor: '#999',
					    			        borderRadius: 3,
					    			        padding: [3, 5]
					    			    }
					    			},
					    			indicator: [
					    				{ name: '食堂餐均消费', max: 25},
					    			    { name: '食糖消费频次', max: 7358},
					    			    { name: '平均成绩', max: 100},
					    			    { name: '挂科门数', max: 10},
					    			    { name: '图书馆借阅频次', max: 360}
					    			]},
					    			series: [{
					    			    name: '学生画像 vs 平均情况',
					    			    type: 'radar',
					    			    data : [
					    			    {
					    			        value : [2.53, 924.93, 75, 0.01, 3.21],
					    			        name : '平均水平（Average）'
					    			    },
					    			    {
					    			        value : result,
					    			        name : '学生实际水平（Actual）'
					    			    }]
					    			}]
					    		}; 
					    		myChart.setOption(option);
					    	</script>
					</div>
				  </div>
				  <div class="content" id="menu1" aria-hidden="true" tabindex="-1">
				    <h3>菜单 1</h3>
				    <p>一些文本内容 1</p>
				  </div>
				  <div class="content" id="menu2" aria-hidden="true">
				    <h3>菜单 2</h3>
				    <p>一些文本内容 2</p>
				  </div>
				  <div class="content" id="menu3" aria-hidden="true" tabindex="-1">
				    <h3>菜单 3</h3>
				    <p>一些文本内容 3</p>
				  </div>
				</div>
				<script>
				$(document).ready(function() {
				    $(document).foundation();
				})
				</script>
			<div class="col-9">
				<!-- 
				<div class="row">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel"  style="height:50%;width:100%">
						<div class="carousel-inner" style="height:100%;width:100%">
							<div class="carousel-item active">
								<img class="d-block w-100" src="<c:url value="/resources/img/Sale.jpg"/>" alt="First slide">
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
					<div id="showborrowtimes" style="width:800px;height: 400px;">

					</div>

				</div>
				-->		
				

				<!--初始化 Foundation JS -->
							
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

	
	
	<!-- 
	<script class="showborrowtimes">

		var data = ${webrecomstatistics.data};
		var keyarr = [];
		var valarr = [];
		for (var item in data) {
			keyarr.push(item);
			valarr.push(data[item]);

		}

		var myChart = echarts.init(document.getElementById('showborrowtimes'));
		var option = {
			title: {
				text: '借阅Top15',
				subtext: '图书馆借阅次数top15的书籍'
			},
			color: ['#008080'],
			tooltip: {
				trigger: 'axis',
				axisPointer: {            // 坐标轴指示器，坐标轴触发有效
					type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid: {
				left: '3%',
				right: '4%',
				bottom: '3%',
				containLabel: true
			},
			xAxis: [
				{
					type: 'value'
				}


			],
			yAxis: [
				{
					type: 'category',
					data: keyarr,
					axisTick: {
						alignWithLabel: true
					}
				}
			],
			series: [
				{
					name: '直接访问',
					type: 'bar',
					barWidth: '60%',
					data: valarr
				}
			]
		};

		myChart.setOption(option);
	</script>
	 -->
</body>
</html>

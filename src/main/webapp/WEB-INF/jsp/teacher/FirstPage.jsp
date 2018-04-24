<%@ page import="wcmc.schoolcard.dto.Webxs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ResourceBundle nginx = ResourceBundle.getBundle("nginx");
%>

<!-- 教师首页 -->
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
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
	<script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
	<script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/laydate/laydate.js"/>"></script>
	<script src="<c:url value="/resources/js/layui/layui.js"/>" charset="utf-8"></script>

</head>

<body>
	
	<div class="row  container-fluid">
		<h2>校园一卡通数据挖掘展示系统</h2>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="col-sm-2 row">
				<a class="nav-item nav-link" href="<%=basePath%>stuLogin/login"><font
					color="#ffffff">登录</font> </a> <a class="nav-item nav-link"
					href="<%=basePath%>teacherLogin/logout"><font color="#ffffff">登出</font>
				</a>
			</div>
		</div>
	</div>
	</nav>

	<!-- 获取session中的值 -->
	
	<div class="container-fluid">
		<div class="row">
			<div class="tabs-content">
				  <div id="menu1">
				  	<h3>成绩情况</h3>
				  	<div id="grade" style="width:800px;height: 400px;">
				  	</div>
				  	<script>
				  		var gradeBar = echarts.init(document.getElementById('grade'));
			    		var result = ${sessionScope.grade};
			    		var key = [];    
				        var value = [];
				        for (var item in result) {
		                    key.push(item);
		                    value.push(result[item]);
		                }
			    		option = {
			    			    color: ['#3398DB'],
			    			    tooltip : {
			    			        trigger: 'axis',
			    			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			    			            type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
			    			        }
			    			    },
			    			    grid: {
			    			        left: '3%',
			    			        right: '4%',
			    			        bottom: '3%',
			    			        containLabel: true
			    			    },
			    			    xAxis : [
			    			        {
			    			            type : 'category',
			    			            data : key,
			    			            axisTick: {
			    			                alignWithLabel: true
			    			            }
			    			        }
			    			    ],
			    			    yAxis : [
			    			        {
			    			            type : 'value'
			    			        }
			    			    ],
			    			    series : [
			    			        {
			    			            name : '平均分',
			    			            type : 'bar',
			    			            barWidth : '60%',
			    			            data : value
			    			        }
			    			    ]
			    			};
			    		gradeBar.setOption(option);
				  	</script>
				  </div>
				  <div id="menu2">
				    <h3>消费情况</h3>
				  	起始时间<input type="text" id="start" size="15">截止时间<input type="text" id="end" size="15">
				  	<button id="getTime" type="button" class="button" >确定</button>
				  	<div id="costDetail" style="width:800px;height: 400px;">
				  	</div>
				  	<script>
					  	$('#getTime').click(function(){
						  	var start = document.getElementById("start").value;
							var end = document.getElementById("end").value;
							if (parseInt(end.replace("-","").replace("-","")) < parseInt(start.replace("-","").replace("-","")) ) {
								alert("时间段不合法");
								return false;
							}
						  	var cost = echarts.init(document.getElementById('costDetail'));	
						  	//var data = ${cost};
						  	var key = [];    
					        var value = [];
					        //for (var item in data) {
					        //    key.push(data[item].key);
					        //    val.push(data[item].value);
					        //}
					        cost.setOption({        //加载数据图表
		                    	xAxis: {
					  		        type: 'category',
					  		        data: key
					  		    },
					  		    yAxis: {
					  		        type: 'value'
					  		    },
					  		    series: [{
					  		        data: value,
					  		        type: 'line'
					  		    }]
		                    });
					        $.post('<%=basePath%>teacherLogin/cost', {'start': start, 'end' : end}).done(function (data) {
					        	//alert(data);
					        	var dataLength = 0;
					        	for (var i in data) {
					        		dataLength++;
					        	}
					        	if (dataLength > 0) {
					        		for (var item in data) {
					                    key.push(item);
					                    value.push(data[item]);
					                }
						        	cost.setOption({
						        		xAxis: {
							  		        data: key
							  		    },
							  		  	series: [{
							  		        data: value
							  		    }]
						        	});
								} else {
									alert("该时间段内没有消费记录");
								}
					        	
					        });
					        
					  	});
				  	</script>
				    <script>
					 	laydate.render({
							elem: '#start',
							theme: 'molv'
						});
					 	laydate.render({
							elem: '#end',
							theme: 'molv'
						});
					</script>
				  </div>
				  <div id="menu3">
				    <h3>成绩状况</h3>
				  </div>
				</div>
				<script>
				$(document).ready(function() {
				    $(document).foundation();
				})
				</script>
			
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

	
	
</body>
</html>

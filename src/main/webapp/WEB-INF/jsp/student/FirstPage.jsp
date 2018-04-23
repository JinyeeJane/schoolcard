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

<script>
	function getCost() {
		var li1 = document.getElementById("li1");
		var li2 = document.getElementById("li2");
		var li3 = document.getElementById("li3");
		var li4 = document.getElementById("li4");
		var menu1 = document.getElementById("menu1");
		var menu2 = document.getElementById("menu2");
		var menu3 = document.getElementById("menu3");
		var menu4 = document.getElementById("menu4");
		
		li1.setAttribute("class","tab-title");
		li1.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li1.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu1.setAttribute("aria-hidden","true");
		menu1.setAttribute("class","content");
		menu1.setAttribute("tabindex","-1");
		li3.setAttribute("class","tab-title");
		li3.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li3.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu3.setAttribute("aria-hidden","true");
		menu3.setAttribute("class","content");
		menu3.setAttribute("tabindex","-1");
		li4.setAttribute("class","tab-title");
		li4.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li4.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu4.setAttribute("aria-hidden","true");
		menu4.setAttribute("class","content");
		menu4.setAttribute("tabindex","-1");
		
		li2.setAttribute("class","tab-title active");
		li2.getElementsByTagName("a")[0].setAttribute("aria-selected","true");
		li2.getElementsByTagName("a")[0].setAttribute("tabindex","0");
		menu2.setAttribute("aria-hidden","false");
		menu2.setAttribute("class","content active");
		menu2.setAttribute("tabindex","0");
	}
	
	function getFirst() {
		var li1 = document.getElementById("li1");
		var li2 = document.getElementById("li2");
		var li3 = document.getElementById("li3");
		var li4 = document.getElementById("li4");
		var menu1 = document.getElementById("menu1");
		var menu2 = document.getElementById("menu2");
		var menu3 = document.getElementById("menu3");
		var menu4 = document.getElementById("menu4");
		
		li2.setAttribute("class","tab-title");
		li2.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li2.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu2.setAttribute("aria-hidden","true");
		menu2.setAttribute("class","content");
		menu2.setAttribute("tabindex","-1");
		li3.setAttribute("class","tab-title");
		li3.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li3.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu3.setAttribute("aria-hidden","true");
		menu3.setAttribute("class","content");
		menu3.setAttribute("tabindex","-1");
		li4.setAttribute("class","tab-title");
		li4.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
		li4.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
		menu4.setAttribute("aria-hidden","true");
		menu4.setAttribute("class","content");
		menu4.setAttribute("tabindex","-1");
		
		li1.setAttribute("class","tab-title active");
		li1.getElementsByTagName("a")[0].setAttribute("aria-selected","true");
		li1.getElementsByTagName("a")[0].setAttribute("tabindex","0");
		menu1.setAttribute("aria-hidden","false");
		menu1.setAttribute("class","content active");
		menu1.setAttribute("tabindex","0");
	}
	
	
	
</script>


</head>

<body>
	
	<div class="row  container-fluid">
		<h2>校园一卡通数据挖掘展示系统</h2>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			
			<div class="navbar-nav col-sm-10 row">
				<ul class="tabs" data-tab="">
				  <li id="li1" class="tab-title active"><a href="javascript:void(0)" aria-selected="true" tabindex="0" onclick="getFirst()">学生主页</a></li>
				  <li id="li2" class="tab-title"><a href="javascript:void(0)" aria-selected="false" tabindex="-1" onclick="getCost()">消费情况</a></li>
				  <li id="li3" class="tab-title"><a href="javascript:void(0)" aria-selected="false" tabindex="-1" id="bad">成绩预警</a></li>
				  <li id="li4" class="tab-title"><a href="<%=basePath%>bookrecom/newbookrecom" aria-selected="false" tabindex="-1" id="recommend">推荐系统</a></li>
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
				  <div class="content active" id="menu1" aria-hidden="false">
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
					    			    	color: '#000',
					    			        backgroundColor: '#aaa',
					    			        borderRadius: 3,
					    			        padding: [3, 5]
					    			    }
					    			},
					    			indicator: [
					    				{ name: '食堂餐均消费', max: 25},
					    			    { name: '食堂消费频次', max: 7358},
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
				  <div class="content" id="menu2" aria-hidden="true" tabindex="-1">
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
					        $.post('<%=basePath%>stuLogin/cost', {'start': start, 'end' : end}).done(function (data) {
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
				  <div class="content" id="menu3" aria-hidden="true" tabindex="-1">
				    <h3>问题课程</h3>
				    <marquee id="flow" scrolldelay=0 onmouseout=this.start() onMouseOver=this.stop() scrollamount=2 direction="left" ></marquee>
				  	<script>
					  	$('#bad').click(function(){
					  		var li1 = document.getElementById("li1");
							var li2 = document.getElementById("li2");
							var li3 = document.getElementById("li3");
							var li4 = document.getElementById("li4");
							var menu1 = document.getElementById("menu1");
							var menu2 = document.getElementById("menu2");
							var menu3 = document.getElementById("menu3");
							var menu4 = document.getElementById("menu4");
							
							li2.setAttribute("class","tab-title");
							li2.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
							li2.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
							menu2.setAttribute("aria-hidden","true");
							menu2.setAttribute("class","content");
							menu2.setAttribute("tabindex","-1");
							li1.setAttribute("class","tab-title");
							li1.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
							li1.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
							menu1.setAttribute("aria-hidden","true");
							menu1.setAttribute("class","content");
							menu1.setAttribute("tabindex","-1");
							li4.setAttribute("class","tab-title");
							li4.getElementsByTagName("a")[0].setAttribute("aria-selected","false");
							li4.getElementsByTagName("a")[0].setAttribute("tabindex","-1");
							menu4.setAttribute("aria-hidden","true");
							menu4.setAttribute("class","content");
							menu4.setAttribute("tabindex","-1");
							
							li3.setAttribute("class","tab-title active");
							li3.getElementsByTagName("a")[0].setAttribute("aria-selected","true");
							li3.getElementsByTagName("a")[0].setAttribute("tabindex","0");
							menu3.setAttribute("aria-hidden","false");
							menu3.setAttribute("class","content active");
							menu3.setAttribute("tabindex","0");
							
							$.post('<%=basePath%>stuLogin/bad').done(function (data) {
								if (data.length > 0) {
									document.getElementById("flow").innerHTML = "需注意科目:"+data;
								} else {
									document.getElementById("flow").innerHTML = "成绩状况良好，请继续保持！"
								}
							});
					  	});
				  	</script>
				  </div>
				  <div class="content" id="menu4" aria-hidden="true" tabindex="-1">
				  </div>
				  <script>
				  	$('#recommend').click(function(){
				  		window.location.href = "<%=basePath %>bookrecom/newbookrecom";
				  	});
				  </script>
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

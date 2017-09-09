<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 17/9/7
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>'selectStatByType.jsp'</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="<c:url value="/resources/js/echarts.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1/jquery-3.2.1.js"/>"></script>
</head>

<body>
<div id="main" style="height: 500px;width: 600px;">
    <!-- 这里以后是地图 -->
</div>

<script>

    var data = ${Webrecomstatistics.data};

    var keyarr = [];
    var valarr = [];
    for (var item in data){
        keyarr.push(item);
        valarr.push(data[item]);

    }

    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: '${Webrecomstatistics.type}',
            subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
        },
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
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
                type : 'value'
            }


        ],
        yAxis : [
            {
                type : 'category',
                data : keyarr,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        series : [
            {
                name:'直接访问',
                type:'bar',
                barWidth: '60%',
                data:valarr
            }
        ]
    };

    myChart.setOption(option);

</script>
</body>

</html>
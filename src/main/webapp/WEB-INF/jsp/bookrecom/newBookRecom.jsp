<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/js/layui/css/layui.css"/>"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<div class="layui-container">
    <blockquote class="layui-elem-quote">注意：下述演示中的颜色只是做一个区分作用，并非栅格内置。</blockquote>


    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>移动设备、桌面端的组合响应式展现</legend>
    </fieldset>

    <div class="layui-row">
        <div class="layui-col-xs12 layui-col-md8">
            <div class="grid-demo grid-demo-bg1">移动：12/12、桌面：8/12</div>
        </div>
        <div class="layui-col-xs6 layui-col-md4">
            <div class="grid-demo">移动：6/12、桌面：4/12</div>
        </div>
        <div class="layui-col-xs6 layui-col-md12">
            <div class="grid-demo grid-demo-bg2">移动：6/12、桌面：12/12</div>
        </div>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>移动设备、平板、桌面端的复杂组合响应式展现</legend>
    </fieldset>

    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <div class="grid-demo grid-demo-bg1">移动：6/12 | 平板：6/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <div class="grid-demo layui-bg-red">移动：6/12 | 平板：6/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4">
            <div class="grid-demo layui-bg-blue">移动：4/12 | 平板：12/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm7 layui-col-md8">
            <div class="grid-demo layui-bg-green">移动：4/12 | 平板：7/12 | 桌面：8/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm5 layui-col-md4">
            <div class="grid-demo layui-bg-black">移动：4/12 | 平板：5/12 | 桌面：4/12</div>
        </div>
    </div>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>书籍查询</legend>
    </fieldset>
    <div class="layui-row">
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <div class="grid-demo grid-demo-bg1">移动：6/12 | 平板：6/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs6 layui-col-sm6 layui-col-md4">
            <div class="grid-demo layui-bg-red">移动：6/12 | 平板：6/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm12 layui-col-md4">
            <div class="grid-demo layui-bg-blue">移动：4/12 | 平板：12/12 | 桌面：4/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm7 layui-col-md8">
            <div class="grid-demo layui-bg-green">移动：4/12 | 平板：7/12 | 桌面：8/12</div>
        </div>
        <div class="layui-col-xs4 layui-col-sm5 layui-col-md4">
            <div class="grid-demo layui-bg-black">移动：4/12 | 平板：5/12 | 桌面：4/12</div>
        </div>
    </div>

</div>
<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>

</script>

</body>
</html>
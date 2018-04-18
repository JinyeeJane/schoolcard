<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 18/4/16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>

</head>
<body>
<h2>查询结果</h2>
<div class="table-scroll">
<table>
    <thead>
    <tr>
        <th>title</th>
        <th>author</th>
        <th>cbrq</th>
        <th>ztc</th>
        <th>ys</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${result4query}" var="item"  >
        <tr>
            <td>${item.title}</td>
            <td>${item.author}</td>
            <td>${item.cbrq}</td>
            <td>${item.ztc}</td>
            <td>${item.ys}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>

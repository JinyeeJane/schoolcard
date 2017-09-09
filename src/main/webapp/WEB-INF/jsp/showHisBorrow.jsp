<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 17/9/9
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<c:forEach items="${listOfBroBookInfo}" var="item" >
    <li> ${item.title}</li>
</c:forEach>
<br>
</body>
</html>

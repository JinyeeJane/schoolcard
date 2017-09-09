<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Channings
  Date: 17/9/9
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showRecomTop15</title>
</head>
<body>

<br>
<c:forEach items="${listOfRecBooks}" var="item" >
   <li> ${item.title}</li>
</c:forEach>
<br>
</body>
</html>

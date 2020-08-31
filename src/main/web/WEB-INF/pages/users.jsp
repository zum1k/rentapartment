<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 25.08.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<ul>
    <c:forEach var="user" items="${users}">
        <p>${user}</p>
    </c:forEach>
</ul>

</body>
</html>

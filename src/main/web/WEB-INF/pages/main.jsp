<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <title>Main</title>
</head>
<body>
<jsp:include page="header.jsp" />
<ul>
    <c:forEach var="advertisement" items="${advertisements}">
        <p>${advertisement.advertisement}</p>
        <p>${advertisement.address}</p>
    </c:forEach>
</ul>
</body>
</html>

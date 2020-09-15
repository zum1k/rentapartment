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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <c:forEach var="user" items="${users}">
                <div class="col-4">
                    <div class="shadow-sm m-2 p-2 bg-white rounded">
                        <p>${user.login}</p>
                        <p>${user.email}</p>
                        <a href="link" class="btn btn-danger">ADD LOCALE, remove user</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

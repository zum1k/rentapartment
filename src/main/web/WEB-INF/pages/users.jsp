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
<div class="wrapper">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <c:forEach var="user" items="${users}">
                <a class="advertisement_wrapper_wrapper col-4">
                    <div class="shadow m-2 p-1 bg-white rounded">
                        <div class="user-info">
                                ${user.login} ${user.email}
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

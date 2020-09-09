<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 19.07.2020
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page import="com.training.rentapartment.entity.UserType" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<nav>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/controller?command=link_to_login">Войти</a> |
    </c:if>
    <c:if test="${sessionScope.user != null && sessionScope.user.type == UserType.ADMIN}">
        <a href="${pageContext.request.contextPath}/controller?command=show_all_users">Все юзеры</a> |
    </c:if>
    <c:if test="${sessionScope.user != null && sessionScope.user.type != UserType.ADMIN}">
        <a href="${pageContext.request.contextPath}/controller?command=show_user_ad">Страница пользователя</a> |
    </c:if>
    <c:if test="${sessionScope.user != null}">
        <a href="${pageContext.request.contextPath}/controller?command=logout">Выйти</a> |
    </c:if>
</nav>
<h2>HEADER</h2>

</body>
</html>

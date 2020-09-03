<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 19.07.2020
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<nav><a href="${pageContext.request.contextPath}/controller?command=show_all_users">На главную</a> |
    <a href="${pageContext.request.contextPath}/controller?command=link_to_login">Войти</a>
    | <a href="${pageContext.request.contextPath}/controller?command=link_to_add_ad">Добавить объявление</a>
    | <a href="${pageContext.request.contextPath}/controller?command=show_all_users">Все юзеры</a> |
    <a href="${pageContext.request.contextPath}/controller?command=link_to_upload_images">Добавить изображение</a></nav>
<h2>HEADER</h2>

</body>
</html>

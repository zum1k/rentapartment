<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 24.06.2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
 <title>Client Page</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
HELLO FROM CLIENT PAGE
<a href="${pageContext.request.contextPath}/controller?command=link_to_add_ad">Добавить объявление</a>
<a href="${pageContext.request.contextPath}/controller?command=link_to_main">На главную</a>
<br/>
МОИ ОБЪЯВЛЕНИЯ:
<c:forEach var="advertisement" items="${advertisements}">
 <a class="advertisement_wrapper col-4"
    href="${pageContext.request.contextPath}/controller?command=show_advertisement&advertisement_id=${advertisement.advertisement.adId}">
  <p>${advertisement.advertisement} ${advertisement.address} </p>
 </a>
</c:forEach>
${sessionScope.user}
${sessionScope.user.id}
${sessionScope.user.login}
</ul>
почта:
<br/>
<a href="${pageContext.request.contextPath}/controller?command=logout">Выйти</a>
</body>
</html>

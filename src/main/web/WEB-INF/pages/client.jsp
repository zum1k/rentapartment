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
</head>
<body>
 HELLO FROM CLIENT PAGE
 <a href="${pageContext.request.contextPath}/controller?command=link_to_add_ad">Добавить объявление</a> |
 МОИ ОБЪЯВЛЕНИЯ:ul>
 <c:forEach var="advertisement" items="${advertisements}">
  <p>${advertisement}</p>
 </c:forEach>
 </ul>
 почта:
 <br/>
 <a href="main.jsp">Выйти</a>
 <input type="hidden" name="user" value = ${sessionScope.user.userId}>
</body>
</html>

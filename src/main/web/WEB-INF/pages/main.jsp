<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<input type="hidden" name="command" value="show_all_users"/>
     <c:forEach var="user" items="${users}">
         <p>${user}</p>
     </c:forEach>
</body>
</html>

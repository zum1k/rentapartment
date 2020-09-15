<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 24.06.2020
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<h4 align="center">
    <body>
    <a href="${pageContext.request.contextPath}/controller?command=show_all_advertisements"> <fmt:message key = "header.home"/> </a>
    <br/>
    <div class="login-form-1" >
        <h2><fmt:message key = "titles.register"/></h2>
        </br>
        <form action="${pageContext.request.contextPath}/controller?command=register" method="post">
            <div class="form-group">
                <input type="text" required name="login" class="form-control" placeholder=<fmt:message key = "message.think-login"/> value=""/>
            </div>
            <div class="form-group">
                <input type="password" required name = "password" class="form-control" placeholder=<fmt:message key = "message.think-password"/> value=""/>
            </div>
            <div class="form-group">
                <input type="email" required name = "email" class="form-control" placeholder=<fmt:message key = "message.email"/> value=""/>
            </div>
             </br>
            <div class="form-group">
                <input type="submit" class="btnSubmit" value=<fmt:message key = "button.register"/>
            </div>
        </form>
    </div>
    </body>
   </h4>
</html>

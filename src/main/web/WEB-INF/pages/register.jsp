<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 24.06.2020
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<h4 align="center">
    <body>
    <a href="${pageContext.request.contextPath}/controller?command=show_all_users">На главную</a>
    <br/>
    <br/>
    <form name="RegistrationForm" method="POST" action="controller?command=register">
        <fieldset>
            <legend>РЕГИСТРАЦИЯ</legend>
            <br/>
            <input type="text" name="login" placeholder="Придумайте логин" value=""><br/>
            <br/>
            <input type="password" name="password" placeholder="Придумайте пароль" value=""><br/>
            <br/>
            <input type="email" name="email" placeholder="user@email.com" value=""><br/>
            <br/>
            <input type="submit" value="Зарегистрироваться">
        </fieldset>
    </form>
    </body>
</h4>
</html>

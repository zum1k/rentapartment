<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login</title></head>
<h4 align="center">
    <a href="${pageContext.request.contextPath}/controller?command=show_all_users">На главную</a>
    <br/>
    <br/>
    <body>
    <form name="loginForm" method="POST" action="controller?command=login">
        <fieldset>
            <legend>ВХОД</legend>
            <input type="text" required id="login" name="login" placeholder="логин" value="">
            <br/>
            <br/>
            <input type="password" required id="password" name="password" placeholder="пароль" value="">
            <br/>
            <br/>
            <input type="submit" value="Войти">
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/controller?command=link_to_register">Зарегистрироваться</a>
        </fieldset>
    </form>
    </body>
</h4>
</html>
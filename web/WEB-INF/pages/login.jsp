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
<body><h3>Login</h3>
<hr/>
<form name="loginForm" method="POST"
      action="controller?command=login">
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <br/>
    <input type="submit" value="Войти">
</form>
<hr/>
</body>
</html>
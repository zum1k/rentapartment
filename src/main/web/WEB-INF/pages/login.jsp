<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<%--<div class="wrapper">--%>
<%--<h4 align="center">--%>
<%--    <a href="${pageContext.request.contextPath}/controller?command=show_all_advertisements">На главную</a>--%>
<%--    <br/>--%>
<%--    <form name="loginForm" method="POST" action="controller?command=login">--%>
<%--        <fieldset>--%>
<%--            <legend>ВХОД</legend>--%>
<%--            <input type="text" required id="login" name="login" placeholder="логин" value="">--%>
<%--            <br/>--%>
<%--            <br/>--%>
<%--            <input type="password" required id="password" name="password" placeholder="пароль" value="">--%>
<%--            <br/>--%>
<%--            <br/>--%>
<%--            <input type="submit" value="Войти">--%>
<%--            <br/>--%>
<%--            <br/>--%>
<%--            <a href="${pageContext.request.contextPath}/controller?command=link_to_register">Зарегистрироваться</a>--%>
<%--        </fieldset>--%>
<%--    </form>--%>
<%--</h4>--%>
<%--</div>--%>
<div class="login-form-1" >
    <h3>Login</h3>
    <form action="/controller?command=login" method="post">
    <div class="form-group">
        <input type="text" required name = "login" class="form-control" placeholder="Your Login *" value=""/>
    </div>
    <div class="form-group">
        <input type="password" required name = "password" class="form-control" placeholder="Your Password *" value=""/>
    </div>
    <div class="form-group">
        <input type="submit" class="btnSubmit" value="Login"/>
    </div>
    <div class="form-group">
        <a href="${pageContext.request.contextPath}/controller?command=link_to_register" class="btnForgetPwd">Register</a>
    </div>
    </form>

</div>

</body>
</html>
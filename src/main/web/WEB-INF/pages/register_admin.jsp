<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 14.09.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<h4 align="center">
    <body>
    <a href="${pageContext.request.contextPath}/controller?command=show_all_advertisements">На главную</a>
    <br/>
    <div class="login-form-1" >
        <h2>Register Admin</h2>
        </br>
        <form action="${pageContext.request.contextPath}/controller?command=register_admin" method="post">
            <div class="form-group">
                <input type="text" required name="login" class="form-control" placeholder="Write Login *" value=""/>
            </div>
            <div class="form-group">
                <input type="password" required name = "password" class="form-control" placeholder="Write Password *" value=""/>
            </div>
            <div class="form-group">
                <input type="email" required name = "email" class="form-control" placeholder="Write Email*" value=""/>
            </div>
            </br>
            <div class="form-group">
                <input type="submit" class="btnSubmit" value="Register"/>
            </div>
        </form>
    </div>
    </body>
</h4>
</html>
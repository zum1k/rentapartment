<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 14.09.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.sessionLanguage}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-4 m-auto py-4 text-center">
                <h3>
                    <fmt:message key="titles.register-admin"/>
                </h3>
                <form action="${pageContext.request.contextPath}/controller?command=register_admin" method="post">
                    <div class="form-group">
                        <input type="text" required name="login" class="form-control" placeholder=
                        <fmt:message key="message.put-login"/> value=""/>
                    </div>
                    <div class="form-group">
                        <input type="password" required name="password" class="form-control" placeholder=
                        <fmt:message key="message.put-password"/> value=""/>
                    </div>
                    <div class="form-group">
                        <input type="email" required name="email" class="form-control" placeholder=
                        <fmt:message key="message.email"/> value=""/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-dark" value=<fmt:message key="button.register"/>/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
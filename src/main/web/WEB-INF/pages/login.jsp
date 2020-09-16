<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.sessionLanguage}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>

<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-4 m-auto py-4 text-center">
                <h3><fmt:message key="titles.login"/></h3>
                <form action="${pageContext.request.contextPath}/controller?command=login" method="post">
                    <div class="form-group">
                        <input type="text" required name="login" class="form-control" placeholder=
                        <fmt:message key="message.login"/> value=""/>
                    </div>
                    <div class="form-group">
                        <input type="password" required name="password" class="form-control" placeholder=
                        <fmt:message key="message.password"/> value=""/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-dark" value=<fmt:message key="button.login"/> />
                    </div>
                    <div class="form-group">
                        <a href="${pageContext.request.contextPath}/controller?command=link_to_register"
                           class="btn btn-danger"> <fmt:message key="titles.register"/>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
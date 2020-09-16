<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 26.08.2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.sessionLanguage}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Upload images</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-4 m-auto py-4 text-center">
                <form enctype="multipart/form-data" method="post"
                      action="controller?command=upload_images&advertisement_id=${advertisement_id}">
                    <div class="form-group">
                        <input type="file" name="file" multiple/>
                    </div>
                    <div class="form-group">
                        <input type="submit" value= <fmt:message key = "button.send"/>/>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>

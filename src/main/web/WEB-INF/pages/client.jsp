<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 24.06.2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Client Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>

<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <h3><fmt:message key="advertisement.my-advertisements"/></h3>
    <div class="container">
        <div class="row">
            <c:forEach var="advertisement" items="${advertisements}">
                <div class="advertisement_wrapper col-4">
                    <a href="${pageContext.request.contextPath}/controller?command=show_advertisement&advertisement_id=${advertisement.advertisement.adId}">
                        <div class="shadow m-2 p-1 bg-white rounded">
                            <div class="advertisement-image">
                            </div>
                            <div class="advertisement-info">
                                <c:if test="${advertisement.imageList[0] != null}">
                                    <img src="data:image/jpg;base64,${advertisement.imageList[0].getImage()}"
                                         width="300"
                                         height="200"/>
                                </c:if>
                                <c:if test="${advertisement.imageList[0] == null}">
                                    <img src="${pageContext.request.contextPath}/Images/default_apartment2.jpg"
                                         width="300"
                                         height="200"/>
                                </c:if>
                                    ${advertisement.advertisement.cost}
                                </br>
                                    ${advertisement.advertisement.rooms}к ${advertisement.advertisement.square}/${advertisement.advertisement.livingSquare}/${advertisement.advertisement.kitchenSquare}
                            </div>
                            <div class="advertisement-address">
                                    ${advertisement.address.street} ${advertisement.address.houseNumber}
                            </div>
                        </div>
                    </a>
                    <form>
                        <button type="submit" formmethod="post"
                                formaction="${pageContext.request.contextPath}/controller?command=delete_ad&advertisement_id=${advertisement.advertisement.adId}">
                            <fmt:message key="button.delete-ad"/>
                        </button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>

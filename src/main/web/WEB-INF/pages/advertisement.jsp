<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Ad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
    <div class="wrapper shadow pb-5">
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div class="row py-3">
                <div class="col-8">
                    <div class="container">
                        <div class="row">
                            <c:if test="${advertisement.imageList[0] != null}">
                                <c:forEach var="image" items="${advertisement.imageList}">
                                    <div class="col-6">
                                        <img src="data:image/jpg;base64,${image.getImage()}" class="w-100"/>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <c:if test="${advertisement.imageList[0] == null}">
                                <div class="col-6">
                                    <img src="${pageContext.request.contextPath}/Images/default_apartment2.jpg"
                                         alt="Default Image" class="w-100"/>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <p>COST: ${advertisement.advertisement.cost} </p>
                    <p>ROOMS: ${advertisement.advertisement.rooms}</p>
                    <p>FLOOR: ${advertisement.advertisement.floor}</p>
                    <p>SQUARE: ${advertisement.advertisement.square}</p>
                    <p>KITCHEN ${advertisement.advertisement.kitchenSquare}</p>
                    <p>LIVING SQUARE: ${advertisement.advertisement.livingSquare}</p>
                    <p>OWNER: ${advertisement.advertisement.owner}</p>
                    <p>PHONE: ${advertisement.advertisement.phoneNumber}</p>
                    <p>DESCRIPTION: ${advertisement.advertisement.description}</p>
                    <p>CITY: ${advertisement.address.city}</p>
                    <p>STREET: ${advertisement.address.street}</p>
                    <p>HOUSE NUMBER ${advertisement.address.houseNumber} </p>
                    <p>HOUSE INDEX ${advertisement.address.houseIndex} </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

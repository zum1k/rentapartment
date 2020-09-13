<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 24.06.2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html>
<head>
 <title>Client Page</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
МОИ ОБЪЯВЛЕНИЯ:
<div class="container">
 <div class="row">
  <c:forEach var="advertisement" items="${advertisements}">
   <a class="advertisement_wrapper col-4" href="${pageContext.request.contextPath}/controller?command=show_advertisement&advertisement_id=${advertisement.advertisement.adId}">
    <div class="shadow m-2 p-1 bg-white rounded">
     <div class="advertisement-image">
     </div>
     <div class="advertisement-info">
       ${advertisement.advertisement.cost}
      </br>
       ${advertisement.advertisement.rooms}к ${advertisement.advertisement.square}/${advertisement.advertisement.livingSquare}/${advertisement.advertisement.kitchenSquare}
     </div>
     <div class="advertisement-address">
       ${advertisement.address.street} ${advertisement.address.houseNumber}
     </div>
    </div>
   </a>
   <a href="${pageContext.request.contextPath}/controller?command=delete_ad&advertisement_id=${advertisement.advertisement.adId}" class="nav-link">Удалить объявление</a>
  </c:forEach>
 </div>
</div>
</body>
</html>

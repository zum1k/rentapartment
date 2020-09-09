<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Main</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css" />
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"/>
            <div class="container">
                <div class="row">
                    <c:forEach var="advertisement" items="${advertisements}">
                        <div class="advertisement_wrapper col-4">
                            <div class="shadow m-2 p-1 bg-white rounded">
                               <div class ="advertisement-image">
                                  ${advertisement.advertisement.cost}
                               </div>
                                <div class="advertisement-info">
                                    ${advertisement.advertisement.rooms}к ${advertisement.advertisement.square}/${advertisement.advertisement.livingSquare}/${advertisement.advertisement.kitchenSquare}
                                </div>
                                <div class="advertisement-address">
                                    ${advertisement.address.street} ${advertisement.address.houseNumber}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </body>
</html>

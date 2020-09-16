<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 21.06.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.sessionLanguage}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
</head>
<body>
<%--<fmt:setLocale value="${sessionScope.sessionLanguage}"/>--%>
<div class="wrapper shadow pb-5">
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-2 py-3">
                <form action="${pageContext.request.contextPath}/controller?command=show_all_advertisements_by_filter"
                      method="post">
                    <div class="form-group">
                        <label for="min_cost"><fmt:message key="filter.min-cost"/> </label>
                        <input type="number" step="1" min="0" max="1999999" id="min_cost" name="min_cost"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="max_cost"><fmt:message key="filter.max-cost"/></label>
                        <input type="number" step="1" min="0" max="2000000" id="max_cost" name="max_cost"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="min_room"><fmt:message key="filter.min-rooms"/></label>
                        <input type="number" step="1" min="0" max="5" id="min_room" name="min_room"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="max_room"><fmt:message key="filter.max-rooms"/></label>
                        <input type="number" step="1" min="0" max="6" id="max_room" name="max_room"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="min_floor"><fmt:message key="filter.min-floor"/></label>
                        <input type="number" step="1" min="0" max="29" id="min_floor" name="min_floor"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="max_floor"><fmt:message key="filter.max-floor"/></label>
                        <input type="number" step="1" min="0" max="30" id="max_floor" name="max_floor"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="min_square"><fmt:message key="filter.min-square"/></label>
                        <input type="number" step="1" min="0" max="999" id="min_square" name="min_square"
                               class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="max_square"><fmt:message key="filter.max-square"/></label>
                        <input type="number" step="1" min="0" max="1000" id="max_square" name="max_square"
                               class="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-dark"><fmt:message key="button.search"/></button>
                </form>
            </div>
            <div class="col-10">
                <div class="container">
                    <div class="row">
                        <c:forEach var="advertisement" items="${advertisements}">
                            <div class="col-4 col-sm-4">
                                <a
                                        href="${pageContext.request.contextPath}/controller?command=show_advertisement&advertisement_id=${advertisement.advertisement.adId}">
                                    <div class="shadow-sm m-2 p-2 bg-white rounded">
                                        <div>
                                            <c:if test="${advertisement.imageList[0] != null}">
                                                <img src="data:image/jpg;base64,${advertisement.imageList[0].getImage()}"
                                                     class="w-100"
                                                />
                                            </c:if>
                                            <c:if test="${advertisement.imageList[0] == null}">
                                                <img src="${pageContext.request.contextPath}/Images/default_apartment2.jpg"
                                                     class="w-100"
                                                />
                                            </c:if>
                                        </div>
                                        <div>
                                            <p><fmt:message key="address.address"/>: ${advertisement.address.street} ${advertisement.address.houseNumber}</p>
                                            <p><fmt:message key="advertisement.cost"/>: ${advertisement.advertisement.cost}$</p>
                                            <p><fmt:message key="advertisement.rooms"/>: ${advertisement.advertisement.rooms}</p>
                                            <p>${advertisement.advertisement.square}/${advertisement.advertisement.livingSquare}/${advertisement.advertisement.kitchenSquare}</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

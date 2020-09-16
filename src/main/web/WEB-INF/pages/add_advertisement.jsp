<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.sessionLanguage}"/>
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
        <div class="row">
            <div class="col-4 m-auto py-4 text-center">
                <form name="add_Ad_Form" accept-charset="UTF-8" method="POST" action="controller?command=add_ad">
                    <div class="form-group">
                        <label for="min_cost"><fmt:message key="filter.min-cost"/> </label>
                        <input type="number" step="1" min="0" max="1999999" id="min_cost" name="min_cost"
                               class="form-control"/>
                        <label>
                            <input type="text" name="city" placeholder=
                            <fmt:message key="message.address.put-city"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <label>
                            <input type="text" accept-charset="UTF-8" name="street" placeholder=
                            <fmt:message key="message.address.put-street"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="message.address.put-house-number"/>
                        <label>
                            <input type="text" name="house_number" placeholder=
                            <fmt:message key="message.address.put-house-number"/> value=""/>
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="message.address.put-house-index"/>
                        <label>
                            <input type="text" name="house_index" placeholder=
                            <fmt:message key="message.address.put-house-index"/> value="">
                        </label></div>
                    <div class="form-group">
                        <label>
                            <fmt:message key="advertisement.rooms"/>
                            <select id="room" name="rooms">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6+</option>
                            </select>
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.floor"/>
                        <label>
                            <input type="text" name="floor" required placeholder=
                            <fmt:message key="advertisement.floor"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.square"/>
                        <label>
                            <input type="text" name="square" required placeholder=
                            <fmt:message key="advertisement.square"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.living-square"/>
                        <label>
                            <input type="text" name="living_square" required placeholder=
                            <fmt:message key="advertisement.living-square"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.kitchen-square"/>
                        <label>
                            <input type="text" name="kitchen_square" required
                                   placeholder=
                                   <fmt:message key="advertisement.kitchen-square"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <label>
                            <fmt:message key="advertisement.owner"/>
                            <select id="owner_list" name="owner">
                                <option value="PRIVATE">PRIVATE</option>
                                <option value="COMPANY">COMPANY</option>
                            </select>
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.cost"/>
                        <label>
                            <input type="text" required name="cost" placeholder=
                            <fmt:message key="advertisement.cost"/> value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <fmt:message key="advertisement.phone"/>
                        <label>
                            <input type="text" required name="phone" placeholder="+375xxxxxxxxx" value="">
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="comment"> <fmt:message key="advertisement.description"/></label>
                        <textarea name="description" accept-charset="UTF-8" id="comment" placeholder=
                        <fmt:message key="message.ad.less-than"/> maxlength="400"></textarea>
                    </div>
                    <input type="submit" value=
                            <fmt:message key="button.send"/>/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

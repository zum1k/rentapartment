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
                        <label for="city"> <fmt:message key="address.city"/> </label>
                        <input type="text" pattern="^[a-zA-Zа-яА-Я]+(?:[\s-][a-zA-Zа-яА-Я]+)*$" class="form-control" required id="city" name="city" placeholder=
                        <fmt:message key="message.address.put-city"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="street"> <fmt:message key="address.street"/> </label>
                        <input type="text" pattern="^[a-zA-Zа-яА-Я]+(?:[\s-][a-zA-Zа-яА-Я]+)*$" class="form-control" required id="street" name="street" placeholder=
                        <fmt:message key="message.address.put-street"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="house-number"> <fmt:message key="address.house-number"/> </label>
                        <input type="text" class="form-control" required id="house-number" name="house_number"
                               placeholder=
                               <fmt:message key="message.address.put-house-number"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="house-index"> <fmt:message key="address.house-index"/> </label>
                        <input type="text" class="form-control" required id="house-index" name="house_index"
                               placeholder=
                               <fmt:message key="message.address.put-house-index"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="rooms"> <fmt:message key="advertisement.rooms"/> </label>
                        <select class="form-control" id="rooms" name="rooms">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6+</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="floor"> <fmt:message key="advertisement.floor"/> </label>
                        <input type="text" class="form-control" required id="floor" name="floor" placeholder=
                        <fmt:message key="advertisement.floor"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="square"> <fmt:message key="advertisement.square"/> </label>
                        <input type="text" class="form-control" required id="square" name="square" placeholder=
                        <fmt:message key="advertisement.square"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="living-square"> <fmt:message key="advertisement.living-square"/> </label>
                        <input type="text" class="form-control" required id="living-square" name="living_square"
                               placeholder=
                               <fmt:message key="advertisement.living-square"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="kitchen-square"> <fmt:message key="advertisement.kitchen-square"/> </label>
                        <input type="text" class="form-control" required id="kitchen-square" name="kitchen_square"
                               placeholder=
                               <fmt:message key="advertisement.kitchen-square"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="owner_list"> <fmt:message key="advertisement.owner"/> </label>
                        <select class="form-control" id="owner_list" name="owner">
                            <option value="PRIVATE">PRIVATE</option>
                            <option value="COMPANY">COMPANY</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="cost"> <fmt:message key="advertisement.cost"/> </label>
                        <input type="text" class="form-control" id="cost" required name="cost" placeholder=
                        <fmt:message key="advertisement.cost"/> value="">
                    </div>
                    <div class="form-group">
                        <label for="phone"> <fmt:message key="advertisement.phone"/> </label>
                        <input type="text" pattern="^(\+375)(29|25|44|33|17)(\d{3})(\d{2})(\d{2})$" class="form-control" id="phone" required name="phone"
                               placeholder="+375xxxxxxxxx" value="">
                    </div>
                    <div class="form-group">
                        <label for="comment"> <fmt:message key="advertisement.description"/></label>
                        <textarea class="form-control" name="description" accept-charset="UTF-8" id="comment"
                                  placeholder=
                                  <fmt:message key="message.ad.less-than"/> maxlength="400"></textarea>
                    </div>
                    <input type="submit" value=<fmt:message key="button.send"/>/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

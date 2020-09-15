<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="pagecontent"/>
<head>
    <title>Add_Advertisement</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form name="add_Ad_Form" accept-charset="UTF-8" method="POST" action="controller?command=add_ad">
    <br/>
    <br/>
    <label>
        <input type="text" name="city" placeholder=
        <fmt:message key="message.address.put-city"/> value="">
    </label><br/>
    <br/>
    <label>
        <input type="text" accept-charset="UTF-8" name="street" placeholder=
        <fmt:message key="message.address.put-street"/> value="">
    </label><br/>
    House Number:<br/>
    <label>
        <input type="text" name="house_number" placeholder=
        <fmt:message key="message.address.put-house-number"/> value=""/>
    </label><br/>
    House Index:<br/>
    <label>
        <input type="text" name="house_index" placeholder=
        <fmt:message key="message.address.put-house-index"/> value="">
    </label><br/>
    <br/>
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
    </label><br/>
    <fmt:message key="advertisement.floor"/><br/>
    <label>
        <input type="text" name="floor" placeholder="Этаж" value="">
    </label><br/>
    <fmt:message key="advertisement.square"/><br/><br/>
    <label>
        <input type="text" name="square" placeholder=
        <fmt:message key="advertisement.square"/> value="">
    </label><br/>
    <fmt:message key="advertisement.living-square"/><br/>
    <label>
        <input type="text" name="living_square" placeholder=" <fmt:message key ="advertisement.living-square"/> value="">
    </label><br/>
    <fmt:message key="advertisement.kitchen-square"/><br/>
    <label>
        <input type="text" name="kitchen_square"
               placeholder=" <fmt:message key ="advertisement.kitchen-square"/> value="">
    </label><br/>
    <br/>
    <label>
        <fmt:message key="advertisement.owner"/>
        <select id="owner_list" name="owner">
            <option value="PRIVATE">PRIVATE</option>
            <option value="COMPANY">COMPANY</option>
        </select>
    </label><br/>
    <fmt:message key="advertisement.cost"/><br/>
    <label>
        <input type="text" name="cost" placeholder=
        <fmt:message key="advertisement.cost"/> value="">
    </label><br/>
    <fmt:message key="advertisement.phone"/><br/>
    <label>
        <input type="text" name="phone" placeholder="+375xxxxxxxxx" value="">
    </label>
    <input type="hidden" name="user_id" value=${sessionScope.user.id}>
    <br/>
    <p>
        <label for="comment"> <fmt:message key="advertisement.description"/></label><br/>
        <textarea name="description" accept-charset="UTF-8" id="comment" placeholder=
        <fmt:message key="message.ad.less-than"/> maxlength="400"></textarea>
    </p>
    <input type="submit" value=" <fmt:message key ="button.send"/>>
</form>
<hr/>
</body>
</html>

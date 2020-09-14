<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:requestEncoding value="utf-8"/>
<html>
<head>
    <title>Add_Advertisement</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form name="add_Ad_Form" accept-charset = "UTF-8" method="POST" action="controller?command=add_ad">
    <br/>
    <br/>
    <label>
        <input type="text"  name="city" placeholder="Введите название города" value="">
    </label><br/>
    <br/>
    <label>
        <input type="text"accept-charset="UTF-8" name="street" placeholder="Введите название улицы" value="">
    </label><br/>
    House Number:<br/>
    <label>
        <input type="text" name="house_number" placeholder="Номер дома" value="">
    </label><br/>
    House Index:<br/>
    <label>
        <input type="text" name="house_index" placeholder="Индекс дома" value="">
    </label><br/>
    <br/>
    <label>
        Rooms:
        <select id="room" name="rooms">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6+</option>
        </select>
    </label><br/>
    Floors:<br/>
    <label>
        <input type="text" name="floor" placeholder="Этаж" value="">
    </label><br/>
    Square:<br/>
    <label>
        <input type="text" name="square" placeholder="Общая площадь" value="">
    </label><br/>
    Living Square:<br/>
    <label>
        <input type="text" name="living_square" placeholder="Жилая площадь" value="">
    </label><br/>
    Kitchen Square:<br/>
    <label>
        <input type="text" name="kitchen_square" placeholder="Площадь кухни" value="">
    </label><br/>
    <br/>
    <label>
        Owner:
        <select id="owner_list" name="owner">
            <option value="PRIVATE">PRIVATE</option>
            <option value="COMPANY">COMPANY</option>
        </select>
    </label><br/>
    Cost:<br/>
    <label>
        <input type="text" name="cost" placeholder="Стоимость" value="">
    </label><br/>
    Phone Number:<br/>
    <label>
        <input type="text" name="phone" placeholder="+375xxxxxxxxx" value="">
    </label>
    <input type="hidden" name="user_id"  value=${sessionScope.user.id}>
    <br/>
    <p>
        <label for="comment">Ваш комментарий:</label><br/>
        <textarea name="description" accept-charset="UTF-8" id="comment" placeholder="Не более 400 символов" maxlength="400"></textarea>
    </p>
    <input type="submit" value="Отправить">
</form>
<hr/>
</body>
</html>

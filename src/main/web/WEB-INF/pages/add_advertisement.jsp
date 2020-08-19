<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add_Advertisement</title>
</head>
<body>
<form enctype = multipart/form-data method="POST" action="controller?command=add_ad">
    //ADDRESS
    <br/>
    <br/>
    <input type="text" name="city"  placeholder="Введите название города"value=""><br/>
   <br/>
    <input type="text" name="street"  placeholder="Введите название улицы" value=""><br/>
    House Number:<br/>
    <input type="text" name="house_number"  placeholder="Номер дома"value=""><br/>
    House Index:<br/>
    <input type="text" name="house_index"  placeholder="Индекс дома"value=""><br/>
    Rooms:<br/>
    <input type="text" name="rooms"  placeholder="user@email.com"value=""><br/>
    Floors:<br/>
    <input type="text" name="floors" value=""><br/>
    Square:<br/>
    <input type="text" name="square" value=""><br/>
    Living Square:<br/>
    <input type="text" name="living_square" value=""><br/>
    Kitchen Square:<br/>
    <input type="text" name="kitchen_square" value=""><br/>
    Owner:<br/>
    <input type="text" name="owner" value=""><br/>
    Cost:<br/>
    <input type="text" name=cost" value=""><br/>
    Phone Number:<br/>
    <input type="text" name=phone" value=""><br/>
    Description:<br/>
    <input type="text" name=description" value=""><br/>
    Images: <input type="file" name="image_name"/>
    <br/>
    <input type="submit" value="Отправить">
</form>
<hr/>

</body>
</html>

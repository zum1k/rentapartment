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
<form enctype=multipart/form-data method="POST" action="controller?command=add_ad">
 //ADDRESS
 <br/>
 <br/>
 <label>
  <input type="text" name="city" placeholder="Введите название города" value="">
 </label><br/>
 <br/>
 <label>
  <input type="text" name="street" placeholder="Введите название улицы" value="">
 </label><br/>
 House Number:<br/>
 <label>
  <input type="text" name="house_number" placeholder="Номер дома" value="">
 </label><br/>
 House Index:<br/>
 <label>
  <input type="text" name="house_index" placeholder="Индекс дома" value="">
 </label><br/>
 Rooms:<br/>
 <label>
  <input type="text" name="rooms" placeholder="user@email.com" value="">
 </label><br/>
 Floors:<br/>
 <label>
  <input type="text" name="floors" value="">
 </label><br/>
 Square:<br/>
 <label>
  <input type="text" name="square" value="">
 </label><br/>
 Living Square:<br/>
 <label>
  <input type="text" name="living_square" value="">
 </label><br/>
 Kitchen Square:<br/>
 <label>
  <input type="text" name="kitchen_square" value="">
 </label><br/>
 Owner:<br/>
 <label>
  <input type="text" name="owner" value="">
 </label><br/>
 Cost:<br/>
 <label>
  <input type="text" name=cost" value="">
 </label><br/>
 Phone Number:<br/>
 <label>
  <input type="text" name=phone" value="">
 </label><br/>
 Phone Number:<br/>
 <label>
  <input type="text" name=phone" value="">
 </label><br/>
 Выберете изображения:<br/>
 <p><input type="file" name="images" multiple accept="image/*,image/jpeg">
 <br/>
 <input type="submit" value="Отправить">
</form>
<hr/>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 20.07.2020
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>image_test</title>
</head>
<body>
<form enctype = multipart/form-data method="POST" action="controller?command=add_ad">
    Изображение: <input type="file" name="image_name"/>
    <input type="submit" value="Загрузить"/>
</form>

</body>
</html>

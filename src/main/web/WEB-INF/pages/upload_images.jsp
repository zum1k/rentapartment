<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 26.08.2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload images</title>
</head>
<body>
ad_id = ${advertisement_id}
<form enctype="multipart/form-data" method="post" action="controller?command=upload_images&advertisement_id=${advertisement_id}">
    <p>
        <input type="file" name="file" multiple />
    </p>
    <p>
        <input type="submit" value="Отправить" />
    </p>
</form>

</body>
</html>

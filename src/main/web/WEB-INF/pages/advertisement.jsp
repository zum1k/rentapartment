<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 12.07.2020
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advertisement</title>
</head>
<body>
<p>COST: <%= request.getParameter("cost") %></p>
<p>ROOMS: <%= request.getParameter("rooms") %></p>
<p>FLOOR: <%= request.getParameter("floor") %></p>
<p>SQUARE: <%= request.getParameter("square") %></p>
<p>KITCHEN SQUARE: <%= request.getParameter("kitchen_square") %></p>
<p>LIVING SQUARE: <%= request.getParameter("living_square") %></p>
<p>OWNER: <%= request.getParameter("owner") %></p>
<p>SQUARE: <%= request.getParameter("square") %></p>

private int adId;
private int cost;
private int rooms;
private int floor;
private double square;
private double livingSquare;
private double kitchenSquare;
private OwnerType owner;
private String phoneNumber;
private String adDate;
private int addressId;
private int userId;
private String description;

private int addressId;
private String city;
private String street;
private int houseNumber;
private int houseIndex;

private int adId;
private int imageId;
private String imageURL;
private byte[] imageData;


</body>
</html>

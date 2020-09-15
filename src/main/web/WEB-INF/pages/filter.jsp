<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 14.09.2020
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<form action="${pageContext.request.contextPath}/controller?command=show_all_advertisements_by_filter" method="post">
    <label for="min_cost">Min Cost </label>
    <input type="number" step="100" min="0" max="1999999" id="min_cost" name="min_cost"/>
    <label for="max_cost">Max Cost </label>
    <input type="number" step="100" min="0" max="2000000" id="max_cost" name="max_cost"/>
    <br/>
    <label for="min_room">Min Room </label>
    <input type="number" step="1" min="0" max="5" id="min_room" name="min_room"/>
    <label for="max_room">Max Room </label>
    <input type="number" step="1" min="0" max="6" id="max_room" name="max_room"/>
    <br/>
    <label for="min_floor">Min Floor </label>
    <input type="number" step="1" min="0" max="29" id="min_floor" name="min_floor"/>
    <label for="max_floor">Max Floor </label>
    <input type="number" step="1" min="0" max="30" id="max_floor" name="max_floor"/>
    <br/>
    <label for="min_square">Min Square </label>
    <input type="number" step="1" min="0" max="999" id="min_square" name="min_square"/>
    <label for="max_square">Max Square </label>
    <input type="number" step="1" min="0" max="1000" id="max_square" name="max_square"/>
    <br/>
    <button type="submit">Поиск</button>
</form>

<%--
  Created by IntelliJ IDEA.
  User: smugl
  Date: 19.07.2020
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page import="com.training.rentapartment.entity.UserType" %>

<div class="header_wrapper">
    <nav >
        <c:if test="${sessionScope.user == null}">
            <a href="${pageContext.request.contextPath}/controller?command=link_to_login" class="nav-link">Войти</a>
        </c:if>
        <c:if test="${sessionScope.user != null && sessionScope.user.type == UserType.ADMIN}">
            <a href="${pageContext.request.contextPath}/controller?command=show_all_users" class="nav-link">Все пользователи</a>
            <a href="${pageContext.request.contextPath}/controller?command=show_admins" class="nav-link">Все админы</a>
            <a href="${pageContext.request.contextPath}/controller?command=register_admin" class="nav-link">Зарегистрировать админа</a>
        </c:if>
        <c:if test="${sessionScope.user != null && sessionScope.user.type != UserType.ADMIN}">
            <a href="${pageContext.request.contextPath}/controller?command=show_user_ad" class="nav-link">Страница пользователя</a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <a href="${pageContext.request.contextPath}/controller?command=logout" class="nav-link">Выйти</a>
        </c:if>

    </nav>
</div>

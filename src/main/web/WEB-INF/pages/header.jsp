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

<%--<div class="header_wrapper">--%>
<%--    <nav>--%>
<%--        <c:if test="${sessionScope.user == null}">--%>
<%--        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_login" class="nav-link">Войти</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${sessionScope.user != null && sessionScope.user.type == UserType.ADMIN}">--%>
<%--        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=logout" class="nav-link">Выйти</a> <a--%>
<%--            href="${pageContext.request.contextPath}/controller?command=show_all_users" class="nav-link">Все--%>
<%--        пользователи</a> <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_admins" class="nav-link">Все--%>
<%--        админы</a> <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_register_admin" class="nav-link">Зарегистрировать--%>
<%--        админа</a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${sessionScope.user != null && sessionScope.user.type != UserType.ADMIN}">--%>
<%--        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=logout" class="nav-link">Выйти</a> <a--%>
<%--                class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_user_ad" class="nav-link">Страница--%>
<%--        пользователя</a>--%>
<%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_add_ad" class="nav-link">Подать объявление</a>--%>
<%--        </c:if>--%>
<%--</nav>--%>
<%--</div>--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand"
       href=""${pageContext.request.contextPath}/controller?command=show_all_advertisements"">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:if test="${sessionScope.user == null}">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_login"
                >Войти</a>
            </c:if>
            <c:if test="${sessionScope.user != null && sessionScope.user.type == UserType.ADMIN}">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=logout">Выйти</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_all_users">Все пользователи</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_admins">Все админы</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_register_admin">Зарегистрировать админа</a>
            </c:if>
            <c:if test="${sessionScope.user != null && sessionScope.user.type != UserType.ADMIN}">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=logout">Выйти</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_user_ad">Страница пользователя</a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_add_ad">Подать объявление</a>
            </c:if>
        </div>
    </div>
</nav>

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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="en"/>
<fmt:setBundle basename="pagecontent"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand"
       href="${pageContext.request.contextPath}/controller?command=show_all_advertisements"><fmt:message key="header.home" /></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon">
        </span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:if test="${sessionScope.user == null}">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=link_to_login"
                ><fmt:message key="header.login" /></a>
            </c:if>
            <c:if test="${sessionScope.user != null && sessionScope.user.type == UserType.ADMIN}">
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="header.log-out" /></a>
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/controller?command=show_all_users"><fmt:message key="header.all-users" /></a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_admins"><fmt:message key="header.all-admins" /></a>
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/controller?command=link_to_register_admin"><fmt:message key="header.add-admin" /></a>
            </c:if>
            <c:if test="${sessionScope.user != null && sessionScope.user.type != UserType.ADMIN}">
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="header.log-out" /></a>
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/controller?command=show_user_ad"><fmt:message key="header.client-page" /></a>
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/controller?command=link_to_add_ad"><fmt:message key="header.add-ad" /></a>
            </c:if>
        </div>
    </div>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/controller?command=set_locale&locale=ru"><fmt:message key="header.lang-ru" /></a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/controller?command=set_locale&locale=en"><fmt:message key="header.lang-en" /></a>
</nav>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <c:url var="bootstrapCssUrl" value="/resources/css/bootstrap.css"/>
        <c:url var="bootstrapRespCssUrl" value="/resources/css/bootstrap-responsive.css"/>
        <c:url var="myCss" value="/resources/css/background.css"/>
        <c:url var="moviejs" value="/resources/js/moviejs.js"/>

        <title>MovieStation: <c:out value="${pageTitle}"/> </title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8" />
        <link href="${bootstrapCssUrl}" rel="stylesheet"/>
        <link href="${bootstrapRespCssUrl}" rel="stylesheet"/>
        <link href="${myCss}" rel="stylesheet"/>
        <script  language="JavaScript" type="text/javascript" src="${moviejs}"></script>
    </head>
    <body>
        <c:url var="main" value="/"/>
        <c:url var="register" value="/register"/>
        <c:url var="login" value="/login/form"/>
        <c:url var="logout" value="/logout"/>

        <div class="navbar">
            <div class="navbar-inner">
                <ul class="nav">
                    <li><a href="${main}">Main</a></li>
                </ul>
                <ul class="nav pull-right">
                    <sec:authorize access="authenticated" var="authenticated"/>
                    <c:choose>
                        <c:when test="${authenticated}">
                            <sec:authentication var="userId" property="principal.id"/>
                            <c:url var="profile" value="/profile/user/${userId}"/>
                            <li><a href="${profile}"><sec:authentication property="principal.username"/></a></li>
                            <li><a href="${logout}">Logout</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a href="${register}">Register</a></li>
                            <li><a href="${login}">Login</a></li>
                            </c:otherwise>
                        </c:choose>
                </ul>
            </div>
        </div>
        <c:url var="movies" value="/movies"/>
        <c:url var="search" value="/search"/>
        <div class="container-fluid">
            <div class="row">
                <div class="span3">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="${movies}">List movies</a></li>
                        <li><a href="${search}">Search</a></li>

                        <sec:authorize url="/admin">
                            <c:url var="listUsers" value="/admin/users"/>
                            <li><a href="${listUsers}">List users</a></li>

                        </sec:authorize>
                    </ul>
                </div>
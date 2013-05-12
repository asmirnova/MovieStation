<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="./includes/header.jsp"/>

<c:url var="register" value="/register"/>
<c:url var="loginPost" value="/login"/>

<div class="container">
    <div class="span6 offset3 well">
        <div class="row">
            <form action="${loginPost}" method="POST" class="span4 offset1">
                <h1 class="text-center">Login</h1>
                <c:if test="${param.error != null}">
                    <div class="alert alert-error">
                        Failed to login.
                        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                        </c:if>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        You have been logged out.
                    </div>
                </c:if>
                <div class="control-group">
                    <label class="control-label" for="username">Username</label>
                    <div class="controls">
                        <input type="text" id="username" name="username" class="span4" value="${user.login}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <input type="password" id="password" name="password" class="span4" value="" required>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
                    </div>
                </div>
                <a href="${register}">Sign up</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="./includes/footer.jsp"/>


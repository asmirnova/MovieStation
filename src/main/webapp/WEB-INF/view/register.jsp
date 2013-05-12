<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="./includes/header.jsp"/>
<c:url var="login" value="/login/form"/>
<c:url var="register" value="/register"/>
<div class="container">
    <div class="span6 offset3 well">
        <div class="row">
            <form action="${register}" method="POST" class="span4 offset1" modelAttribute="signupForm">
                <h1 class="text-center">Registration</h1>
                <div class="control-group">
                    <c:if test="${not empty errors}">
                        <c:forEach var="error" items="${errors}" >  
                            <div class="alert alert-error"><c:out value="${error.defaultMessage}"></c:out></div>
                        </c:forEach>
                    </c:if>
                </div>
                <div class="control-group">
                    <label class="control-label" for="username">Username</label>
                    <div class="controls">
                        <input type="text" id="username" name="username" class="span4" value="${user.username}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="password">Password</label>
                    <div class="controls">
                        <input type="password" id="password" name="password" class="span4" value="" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="firstName">First name</label>
                    <div class="controls">
                        <input type="text" id="firstName" name="firstName" class="span4" value="${user.firstName}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="lastName">Last name</label>
                    <div class="controls">
                        <input type="text" id="lastName" name="lastName" class="span4" value="${user.lastName}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="email">Email</label>
                    <div class="controls">
                        <input type="email" id="email" name="email" class="span4" value="${user.email}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="birthday">Birthday</label>
                    <div class="controls">
                        <input type="datetime" id="birthday" name="birthday" class="span4" value="${user.birthday}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="phoneNumber">Phone number</label>
                    <div class="controls">
                        <input type="text" id="phoneNumber" name="phoneNumber" class="span4" value="${user.phoneNumber}" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="picUrl">Picture URL</label>
                    <div class="controls">
                        <input type="url" id="picUrl" name="picUrl" class="span4" value="${user.picUrl}">
                    </div>
                </div> 
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-primary btn-block btn-large">Register</button>
                    </div>
                </div>
                <a href="${login}">Sign in</a>
            </form>
        </div>
    </div>
</div>


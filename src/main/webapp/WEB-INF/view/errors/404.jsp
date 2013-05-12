<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Page not found" scope="request"/>
<jsp:include page="../includes/header.jsp"/>
<div id="outer">
    <div id="middle">
        <div id="inner">
            <h1>Oops...</h1>
            <h3>This page doesn't exist, <a href="">click here</a> to go back.</h3>
            <c:url var="imageUrl" value="/resources/images/404.gif"/>
            <img src="${imageUrl}">
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
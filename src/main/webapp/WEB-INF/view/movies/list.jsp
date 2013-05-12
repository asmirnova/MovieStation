<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/header.jsp"/>

<div class="span9">
    <div class="pagination pagination-centered">
        <ul>
            <c:set var="maxPerPage" value="5"/>
            <c:if test="${curPage != 1}">
                <c:url var="prevPage" value="/movies/${curPage-1}/${maxPerPage}"/>
                <li><a href="${prevPage}">Prev</a></li>
                </c:if>
                <c:forEach begin="1" end="${numPages}" var="i">
                    <c:choose>
                        <c:when test="${curPage eq i}">
                        <li><a href="#">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <c:url var="otherPage" value="/movies/${i}/${maxPerPage}"/>
                        <li><a href="${otherPage}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${curPage lt numPages}">
                    <c:url var="nextPage" value="/movies/${curPage+1}/${maxPerPage}"/>
                <li><a href="${nextPage}">Next</a></li>
                </c:if>
        </ul>
    </div>
    <h1>Movies</h1>
    <table class="table table-bordered table-hover table-condensed mytable">
        <thead>
            <tr>
                <th>Title</th>
                <th>Rating</th>
                <th>Year</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty movies}">
                <c:forEach var="movie" items="${movies}">
                    <c:url var="movieProfile" value="/movie/${movie.id}"/>
                    <tr onclick="navigate('${movieProfile}');">
                        <td>${movie.title}</td>
                        <td>${movie.rating}</td>
                        <td>${movie.year}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</div>


<jsp:include page="../includes/footer.jsp"/>

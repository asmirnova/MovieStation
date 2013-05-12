<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="./includes/header.jsp"/>

<div class="container">
    <div class="span6 well">
        <div class="row">
            <div class="span2">
                <sec:authorize access="authenticated" var="authenticated"/>
                <c:choose>
                    <c:when test="${authenticated}">
                        <img src="${user.picUrl}" class="img-polaroid">
                    </c:when>
                </c:choose>
            </div>
            <div class="span4">
                <sec:authorize access="authenticated" var="authenticated"/>
                <c:choose>
                    <c:when test="${authenticated}">
                        <p class="text-left">
                            ${user.firstName}
                            ${user.lastName}
                        </p>
                        <sec:authorize url="/admin">
                            <c:url var="setAdmin" value="/admin/users/setAdmin/${user.id}"/>
                            <c:url var="unsetAdmin" value="/admin/users/unsetAdmin/${user.id}"/>
                            <c:url var="isAdmin" value="/admin/users/isAdmin/${user.id}"/>
                            <c:url var="removeUser" value="/admin/users/removeUser/${user.id}"/>
                            <p id="admin">
                                <a href="${removeUser}" onclick="return confirmDeleteUser();" class="btn btn-small btn-danger">Remove user</a>
                            </p>
                            <script lang="javascript">
                                var isAdmin = serverRequest('${isAdmin}');
                                if (isAdmin === "false") {
                                    text = 'Add admin rights';
                                    adminLink = "${setAdmin}";
                                } else {
                                    text = 'Remove admin rights';
                                    adminLink = "${unsetAdmin}";
                                }
                                a = document.createElement('a');
                                textEl = document.createTextNode(text);
                                a.title = "Admin rights";
                                a.href = adminLink;
                                a.className = "btn btn-small btn-danger";
                                a.appendChild(textEl);
                                document.getElementById('admin').appendChild(a);
                            </script>
                        </sec:authorize>
                        <p class="text-left">
                            ${user.email}
                        </p>
                        <p class="text-left">
                            ${user.birthday}
                        </p>
                        <p class="text-left">
                            ${user.phoneNumber}
                        </p>
                        <p class="text-left">
                            Favorites
                        <ol>
                            <c:forEach var="favorite" items="${user.favorites}">
                                <c:url var="movieUrl" value="/movie/${favorite.id}"/>
                                <li><a href="${movieUrl}"/>${favorite.title}</a></li>
                                </c:forEach>
                        </ol>
                        </p>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<jsp:include page="./includes/footer.jsp"/>

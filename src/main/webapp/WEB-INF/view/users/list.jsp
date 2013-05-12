<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../includes/header.jsp"/>



<div class="span9">
    <div class="pagination pagination-centered">
        <ul>
            <c:set var="maxPerPage" value="5"/>
            <c:if test="${curPage != 1}">
                <c:url var="prevPage" value="/admin/users/${curPage-1}/${maxPerPage}"/>
                <li><a href="${prevPage}">&larr; Prev</a></li>
                </c:if>
                <c:forEach begin="1" end="${numPages}" var="i">
                    <c:choose>
                        <c:when test="${curPage eq i}">
                        <li><a href="#">${i}</a></li>
                        </c:when>
                        <c:otherwise>
                            <c:url var="otherPage" value="/admin/users/${i}/${maxPerPage}"/>
                        <li><a href="${otherPage}">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${curPage lt numPages}">
                    <c:url var="nextPage" value="/admin/users/${curPage+1}/${maxPerPage}"/>
                <li><a href="${nextPage}">Next &rarr;</a></li>
                </c:if>
        </ul>
    </div>
    <h1>Users</h1>
    <table class="table table-bordered table-hover table-condensed mytable">
        <thead>
            <tr>
                <!--<th>Action</th>-->
                <th>Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Phone number</th>
                <th>Picture URL</th>                
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <c:url var="userEdit" value="/profile/user/${user.id}"/>
                    <tr onclick="navigate('${userEdit}');">
<!--                        <td>
                            <div class="btn-group">
                                <a class="btn btn-primary" href="#"><i class="icon-user icon-white"></i> User</a>
                                <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                    <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                                    <li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#"><i class="i"></i> Make admin</a></li>
                                </ul>
                            </div>
                        </td>-->
                        <td>${user.id}</a></td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.birthday}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.picUrl}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="../includes/footer.jsp"/>

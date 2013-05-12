<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../includes/header.jsp"/>

<div class="container">
    <div class="span9">
        <div class="span9 well">
            <div class="row">
                <div class="span3">
                    <c:url var="posterUrl" value="${movie.posterUrl}"/>
                    <img src="${posterUrl}" class="img-polaroid">
                </div>
                <div class="span6">
                    <h1 class="text-left">
                        ${movie.title} (${movie.year})
                    </h1>
                    <sec:authorize access="authenticated" var="authenticated"/>
                    <c:choose>
                        <c:when test="${authenticated}">
                            <c:url var="addToFav" value="/addToFavorites/${movie.id}"/>
                            <c:url var="removeFav" value="/removeFavorites/${movie.id}"/>
                            <c:url var="movieFav" value="/hasFavorite/${movie.id}"/>
                            <div id="favorites">
                            </div>
                            <script lang="javascript">
                                var hasFav = serverRequest('${movieFav}');
                                if (hasFav === "false") {
                                    text = 'Add to favorites';
                                    favLink = "${addToFav}";
                                } else {
                                    text = 'Remove from favorites';
                                    favLink = "${removeFav}";
                                }
                                a = document.createElement('a');
                                newText = document.createTextNode(text);
                                a.title = "Title";
                                a.href = favLink;
                                a.appendChild(newText);
                                document.getElementById('favorites').appendChild(a);
                            </script>
                        </c:when>
                    </c:choose>
                    <c:url var="imgSrc" value="/resources/images/star.png"/>
                    <img src="${imgSrc}" alt="image" />
                    <p class="overstar"><strong>${movie.rating}</strong></p>                
                    <h1>Plot</h1>
                    <p class="text-left">
                        ${movie.plotSimple}
                    </p>
                </div>
            </div>
        </div>
        <div class="span9 well">
            <h2>Comments</h2>
            <c:url var="addComment" value="/addComment/${movie.id}"/>
            <c:url var="getCommentsUrl" value="/getComments/${movie.id}"/>
            <c:url var="deleteComment" value="/deleteComment/"/>
            <sec:authentication var="myId" property="principal.id"/>
            <div id="comments">
            </div>
            <script lang="javascript">
                var data = eval('(' + serverRequest('${getCommentsUrl}') + ')');
                for (var i = 0; i < data.comments.length; i++) {
                    var comment = data.comments[i];
                    commentText = comment["text"];
                    commentTitle = comment["title"];
                    commentId = comment["id"];
                    div = document.createElement('div');
                    h3 = document.createElement('h3');
                    p = document.createElement('p');

                    commentTitleText = document.createTextNode(commentTitle);
                    commentTextText = document.createTextNode(commentText);
                    h3.appendChild(commentTitleText);

                    if (${myId} === comment["userId"]) {
                        deleteCommentHref = document.createElement('a');
                        deleteCommentText = document.createTextNode("Delete");
                        deleteCommentHref.title = "Delete comment";
                        deleteCommentHref.href = "${deleteComment}"+commentId;
                        deleteCommentHref.className = "btn btn-mini btn-danger";
                        deleteCommentHref.appendChild(deleteCommentText);
                        h3.appendChild(deleteCommentHref);
                    }
                    p.appendChild(commentTextText);
                    div.className += "well";
                    div.appendChild(h3);
                    div.appendChild(p);
                    document.getElementById('comments').appendChild(div);
                }

            </script>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>

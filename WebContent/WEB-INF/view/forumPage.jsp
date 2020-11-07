<%-- page descriptor --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- taglib directives --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- scriptlet --%>

<%-- template --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORUM | Forum</title>
<!-- css -->
<link rel="stylesheet" href="/forum/css/master.css">
</head>
<body>
	<div class="container">
		<header class="header">
			<%@ include file="./common/navAuthorized.jsp" %>
		</header>
		
		<main class="main">
			<c:if test="${ not empty requestScope.err }">
				<div class="message--error">
					<span><c:out value="${ requestScope.err }" /></span>
				</div>
			</c:if>
			
			<form class="form" action="/forum/forum" method="POST">
				<div class="form__section">
					<label class="form__label" for="content">Content</label>
					<textarea class="form__textarea" id="content" name="content"></textarea>
				</div>
				<button class="form__button" type="submit">Post</button>
			</form>
			
			<div class="forum">
				<c:choose>
					<c:when test="${ requestScope.posts.size() eq 0 }">
						<div class="dummy-post">
							<p class="dummy-post__paragraph">Be the first to make a post!</p>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="post" items="${ requestScope.posts }">
							<div class="post">
								<span class="post__information">Post ID: <c:out value="${ post.getPostId() }" /></span>
								<span class="post__information">User ID: <c:out value="${ post.getUserId() }" /></span>
								<span class="post__information">Time Stamp: <c:out value="${ post.getTimeStamp() }" /></span>
								<p class="post__content"><c:out value="${ post.getContent() }" /></p>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</main>
		
		<%@include file="./common/footer.jsp" %>
	</div>
</body>
</html>
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
<title>FORUM | Sign in</title>
<!-- css -->
<link rel="stylesheet" href="/forum/css/common/master.css">
<link rel="stylesheet" href="/forum/css/common/navUnauthorized.css">
<link rel="stylesheet" href="/forum/css/common/footer.css">
<link rel="stylesheet" href="/forum/css/signInPage.css">
</head>
<body>
	<div class="container">
		<header class="header">
			<%@ include file="./common/navUnauthorized.jsp" %>
		</header>
		
		<main class="main">
			<c:if test="${ not empty requestScope.err }">
				<div class="message--error">
					<span><c:out value="${ requestScope.err }" /></span>
				</div>
			</c:if>
			
			<h1 class="heading">Sign in</h1>
			
			<form class="form" action="/forum/signIn" method="POST">
				<div class="form__section">
					<label class="form__label" for="userId">User ID</label>
					<input class="form__input" id="userId" name="userId" type="text">
				</div>
				<div class="form__section">
					<label class="form__label" for="password">Password</label>
					<input class="form__input" id="password" name="password" type="password">
				</div>
				<button class="form__button" type="submit">Sign in</button>
			</form>
		</main>
		
		<%@ include file="./common/footer.jsp" %>
	</div>
</body>
</html>
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
<title>FORUM | My page</title>
<!-- css -->
<link rel="stylesheet" href="/forum/css/master.css">
</head>
<body>
	<div class="container">
		<header class="header">
			<%@ include file="./common/navAuthorized.jsp" %>
		</header>
		
		<main class="main">
			<p class="main__paragraph">User ID: <c:out value="${ sessionScope.user.getUserId() }" /></p>
			<p class="main__paragraph">Password: <c:out value="${ sessionScope.user.getPassword() }" /></p>
			<p class="main__paragraph">Time Stamp: <c:out value="${ sessionScope.user.getTimeStamp() }" /></p>
			
			<form class="form" action="/forum/my" method="POST">
				<button class="form__button--danger" type="submit">Unsubscribe</button>
			</form>
		</main>
		
		<%@include file="./common/footer.jsp" %>
	</div>
</body>
</html>
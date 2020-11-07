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
<link rel="stylesheet" href="/forum/css/common/master.css">
<link rel="stylesheet" href="/forum/css/common/navAuthorized.css">
<link rel="stylesheet" href="/forum/css/common/footer.css">
<link rel="stylesheet" href="/forum/css/myPage.css">
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
			
			<table class="table">
				<tbody>
					<tr>
						<td class="table-data">User ID</td>
						<td class="table-data"><c:out value="${ sessionScope.user.getUserId() }" /></td>
					</tr>
					<tr>
						<td class="table-data">Password</td>
						<td class="table-data"><c:out value="${ sessionScope.user.getPassword() }" /></td>
					</tr>
					<tr>
						<td class="table-data">Time Stamp</td>
						<td class="table-data"><c:out value="${ sessionScope.user.getTimeStamp() }" /></td>
					</tr>
				</tbody>
			</table>
			
			<form class="button-only-form" action="/forum/my" method="POST">
				<button class="button-only-form__button--danger" type="submit">Unsubscribe</button>
			</form>
		</main>
		
		<%@include file="./common/footer.jsp" %>
	</div>
</body>
</html>
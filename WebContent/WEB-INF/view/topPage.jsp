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
<title>FORUM | Top</title>
<!-- css -->
<link rel="stylesheet" href="/forum/css/master.css">
</head>
<body>
	<div class="container">
		<header class="header">
			<%@ include file="./common/navUnauthorized.jsp" %>
		</header>
		
		<main class="main">
			<h1 class="main__heading">Welcome to the FORUM.</h1>
			<p class="main__paragraph">Start your conversation now.</p>
		</main>
		
		<%@ include file="./common/footer.jsp" %>
	</div>
</body>
</html>
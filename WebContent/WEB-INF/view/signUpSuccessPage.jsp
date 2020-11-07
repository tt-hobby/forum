<%-- page descriptor --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- scriptlet --%>

<%-- template --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORUM | Top</title>
<!-- css -->
<link rel="stylesheet" href="/forum/css/common/master.css">
<link rel="stylesheet" href="/forum/css/common/navUnauthorized.css">
<link rel="stylesheet" href="/forum/css/common/footer.css">
<link rel="stylesheet" href="/forum/css/signUpSuccessPage.css">
</head>
<body>
	<div class="container">
		<header class="header">
			<%@ include file="./common/navUnauthorized.jsp" %>
		</header>
		
		<main class="main">
			<p class="main__paragraph">We have successfully created your account!</p>
		</main>
		
		<%@ include file="./common/footer.jsp" %>
	</div>
</body>
</html>
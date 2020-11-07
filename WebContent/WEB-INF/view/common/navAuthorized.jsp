<%-- taglib directives --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="nav">
	<ul class="nav__list">
		<li class="nav__list-logo">
			<a class="nav__link" href="/forum/top">FORUM</a>
		</li>
		<li class="nav__list-item">
			<a class="nav__link" href="/forum/my">My page</a>
		</li>
		<li class="nav__list-item">
			<a class="nav__link" href="/forum/forum">Forum</a>
		</li>
		<li class="nav__list-item">
			<a class="nav__link--inactive" href="#"><c:out value="${ sessionScope.user.getUserId() }" /></a>
		</li>
		<li class="nav__list-item">
			<a class="nav__link" class="nav__list-item" href="/forum/signOut">Sign out</a>
		</li>
	</ul>
</nav>
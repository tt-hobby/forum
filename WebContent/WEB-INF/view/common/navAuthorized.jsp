<nav class="nav">
	<ul class="nav__list">
		<li><a class="nav__list-logo" href="/forum/top">FORUM</a></li>
		<li><a class="nav__list-item" href="/forum/my">My page</a></li>
		<li><a class="nav__list-item" href="/forum/forum">Forum</a></li>
		<li><a class="nav__list-item" href="#"><c:out value="${ sessionScope.user.getUserId() }" /></a></li>
		<li><a class="nav__list-item" href="/forum/signOut">Sign out</a></li>
	</ul>
</nav>
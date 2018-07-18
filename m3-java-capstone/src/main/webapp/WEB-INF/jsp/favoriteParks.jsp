<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="favoriteParks" value="/favoriteParks" />

<section>
	<h2>Parks Favorite</h2>
	
	<div>
		<c:forEach var="favorite" items="${favorites}">
			<p>${favorite.code}
			<p>${favorite.count}</p>
		</c:forEach>
	</div>
	
</section>

<%@include file="common/footer.jspf"%>
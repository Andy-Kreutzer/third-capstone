<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Favorite Parks"/>

<%@include file="common/header.jspf"%>

<c:url var="favoriteParks" value="/favoriteParks" />

<section>
	<h2>Favorite Parks Survey Results</h2>
	<div>
		<c:forEach var="favorite" items="${favorites}">
			<div class="favorite">
				<div class="favoriteImg">
					<a href="${parkDetails}"><img class="surveyPic" src="img/parks/${favorite.code.toLowerCase()}.jpg"/></a>
				</div>
				<div class="favoriteTxt">
					<c:if test="${favorite.code == 'CVNP'}" >
						<p>Cuyahoga Valley National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'ENP'}" >
						<p>Everglades National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'GCNP'}" >
						<p>Grand Canyon National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'GNP'}" >
						<p>Glacier National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'GSMNP'}" >
						<p>Great Smoky Mountains National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'GTNP'}" >
						<p>Grand Teton National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'MRNP'}" >
						<p>Mount Rainier National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'RMNP'}" >
						<p>Rocky Mountain National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'YNP'}" >
						<p>Yellowstone National Park</p>
					</c:if> 
					<c:if test="${favorite.code == 'YNP2'}" >
						<p>Yosemite National Park</p>
					</c:if> 
				</div>
				<div class="favoriteVotes">
					<p>Votes: ${favorite.count}</p>
				</div>
			</div>
		</c:forEach>
	</div>
	
</section>

<%@include file="common/footer.jspf"%>
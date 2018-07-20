<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="homePage" value="/homePage" />

<section>
<h1>Parks Home</h1>

<c:forEach var="park" items="${allParks}">
	<div class = "homepageItem">
		<c:url var ="parkDetails" value="/parkDetails">
			<c:param name="parkCode"> ${park.parkCode} </c:param>
		</c:url>
		<div>
			<a href="${parkDetails}"><img class="homepagePic" src="img/parks/${park.parkCode.toLowerCase()}.jpg"/></a>
		</div>
		<div class = "homepageText">
			 <h3>${park.parkName}</h3>
			 <p>${park.parkDescription}</p>
		</div>  
	</div>
</c:forEach>

</section>

<%@include file="common/footer.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="homePage" value="/homePage" />

<section>
	<h2>Parks Home</h2>

	<div>	
		<c:forEach var="park" items="${allParks}">
		<div>
			<img src="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
		</div>
			<p>${park.parkName}</p>
			<p>${park.parkDescription}</p>
		</c:forEach>
	</div>

</section>

<%@include file="common/footer.jspf"%>
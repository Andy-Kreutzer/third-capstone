<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="parkDetails" value="/parkDetails" />

<h2>Parks Details</h2>

  <section id="main-content">
			
				<div id="descriptItem">
					<img src="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
				</div>
				
				<p>${park.parkName}</p>
				<p>${park.parkDescription}</p>
				<p>${park.state}</p>
				<p>${park.acreage}</p>
				<p>${park.elevation}</p>
				<p>${park.milesOfTrail}</p>
				<p>${park.numOfCampsites}</p>
				<p>${park.climate}</p>
				<p>${park.yearFounded}</p>
				<p>${park.quote}</p>
				<p>${park.quoteSource}</p>

				<p>${park.entryFee}</p>
				<p>${park.numOfAnimalSpec}</p>				
    </section>



<%@include file="common/footer.jspf"%>
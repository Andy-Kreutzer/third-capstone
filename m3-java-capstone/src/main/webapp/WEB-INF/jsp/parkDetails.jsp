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
				<p>${park.yearFounded}</p>
				
				<c:forEach var="dailyWeather" items="${parkForecast}">
					<p>${dailyWeather.forecast}</p>					
					<p>${dailyWeather.high}</p>
					<p>${dailyWeather.low}</p>
					<p>${dailyWeather.forecastSuggestion}</p>
					<p>${dailyWeather.tempSuggestion}</p>
				</c:forEach>	
								
		
		<c:url var="formAction" value="parkDetail?parkCode=${park.parkCode}" />
		<form method="GET" action="${formAction}">
				
					
				
				
				
				<label for="temp"> Display temperature in </label>
					<select name="temp">
						<option value="F">Fahrenheit</option>
						<option value="C">Celsius</option>
					</select>
				<input type="submit" value="Select" />		
				
					
				</form>	

    </section>



<%@include file="common/footer.jspf"%>
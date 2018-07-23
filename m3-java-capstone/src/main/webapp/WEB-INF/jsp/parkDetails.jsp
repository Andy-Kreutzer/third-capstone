<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="parkDetails" value="/parkDetails" />


<h2>Parks Details</h2>

  <section id="main-content">
	<div>
		<img src="img/parks/${park.parkCode.toLowerCase()}.jpg" id="detailsImg"/>
	</div>
	<h1>${park.parkName}</h1>
	<p>${park.parkDescription}</p>
	<table>
		<tr>
			<td><p><b>State:</b> ${park.state}</p></td>
			<td><p><b>Acreage:</b> ${park.acreage}</p></td>
		</tr>
		<tr>
			<td><p><b>Elevation:</b> ${park.elevation}</p></td>
			<td><p><b>Miles of Trail:</b> ${park.milesOfTrail}</p></td>
		</tr>
		<tr>
			<td><p><b>Number of Campsites:</b> ${park.numOfCampsites}</p></td>
			<td><p><b>Climate Type: </b>${park.climate}</p></td>
		</tr>
		<tr>
			<td><p><b>Year Founded: </b>${park.yearFounded}</p></td>
			<td><p><b>Entry Fee: $</b>${park.entryFee}</p></td>
		</tr>
		<tr>
			<td><p><b>Number of Animal Species: </b>${park.numOfAnimalSpec}</p></td>
			<td><p><b>Year Founded: </b>${park.yearFounded}</p></td>
		</tr>	
	</table>	
	
	<div id="quote">
		<p id="quoteText"><b><i>"${park.quote}"</i></b></p>
		<p>  -${park.quoteSource}</p>
	</div>
	
	<div class="fiveDay">
		<c:forEach var="dailyWeather" items="${parkForecast}" varStatus="stat">
			<c:if test="${stat.first}">
				<div class="firstDayWeather">
					
					<div>
						<img src="img/weather/${dailyWeather.forecast}.png" id="FirstWeatherImg"/>	
					</div>
					<div class="weatherText">		
						<p><b>High: </b>${dailyWeather.high}  <b>Low: </b>${dailyWeather.low}</p>
						<p>${dailyWeather.forecastSuggestion}</p>
						<p>${dailyWeather.tempSuggestion}</p>
					</div>
				</div>
			</c:if>
			<c:if test="${!stat.first}">
				<div class="dailyWeather">
					<div>
						<img src="img/weather/${dailyWeather.forecast}.png" id="dailyWeatherImg"/>	
					</div>
					<div class="weatherText">		
						<p><b>High: </b>${dailyWeather.high}  <b>Low: </b>${dailyWeather.low}</p>
						<p>${dailyWeather.forecastSuggestion}</p>
						<p>${dailyWeather.tempSuggestion}</p>
					</div>
				</div>
			
			</c:if>
		</c:forEach>	
	</div>
	
	<div class="tempChange">	
		<c:url var="formAction" value="/parkDetails" />
		<form method="GET" action="${formAction}">
					<label  for="temp"> Display temperature in </label>
						<select name="temp" class = "tempDropBox">
							<option value="F">Fahrenheit</option>
							<option value="C">Celsius</option>
						</select>
						<input type="hidden" id="parkCode" name="parkCode" value="${park.parkCode}">
						<button type="submit">
							Select
						</button>	
		</form>	
	</div>
    </section>

<%@include file="common/footer.jspf"%>
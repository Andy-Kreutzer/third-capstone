<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="surveyPage" value="/surveyPage" />

<h2>Parks Survey</h2>

<h2 class="error">${error}</h2>

<form:form action="${submit}" method="POST" modelAttribute="survey">
        <div class="favorite">
                <label for="parkCode">Favorite National Park</label>
                <select name="parkCode">
                	<option value="CVNP">Cuyahoga Valley National Park</option>
                	<option value="ENP">Everglades National Park</option>
                	<option value="GCNP">Grand Canyon National Park</option>
                	<option value="GNP">Glacier National Park</option>
                	<option value="GSMNP">Great Smoky Mountains National Park</option>
                	<option value="GTNP">Grand Teton National Park</option>
                	<option value="MRNP">Mount Rainier National Park</option>
                	<option value="RMNP">Rocky Mountain National Park</option>
                	<option value="YNP">Yellowstone National Park</option>
                	<option value="YNP2">Yosemite National Park</option>
                </select>          
        </div>
        
         <div class="email">
            <label for="email">Your Email</label>
            <form:input path="email" />            
            <form:errors path="email" cssClass="error"/>
        </div>
        
        <div class="state">
                <label for="state">Your State of Residence</label>
                <select name="state">
					<option value="AL">AL</option>
					<option value="AK">AK</option>
					<option value="AR">AR</option>	
					<option value="AZ">AZ</option>
					<option value="CA">CA</option>
					<option value="CO">CO</option>
					<option value="CT">CT</option>
					<option value="DC">DC</option>
					<option value="DE">DE</option>
					<option value="FL">FL</option>
					<option value="GA">GA</option>
					<option value="HI">HI</option>
					<option value="IA">IA</option>	
					<option value="ID">ID</option>
					<option value="IL">IL</option>
					<option value="IN">IN</option>
					<option value="KS">KS</option>
					<option value="KY">KY</option>
					<option value="LA">LA</option>
					<option value="MA">MA</option>
					<option value="MD">MD</option>
					<option value="ME">ME</option>
					<option value="MI">MI</option>
					<option value="MN">MN</option>
					<option value="MO">MO</option>	
					<option value="MS">MS</option>
					<option value="MT">MT</option>
					<option value="NC">NC</option>	
					<option value="NE">NE</option>
					<option value="NH">NH</option>
					<option value="NJ">NJ</option>
					<option value="NM">NM</option>			
					<option value="NV">NV</option>
					<option value="NY">NY</option>
					<option value="ND">ND</option>
					<option value="OH">OH</option>
					<option value="OK">OK</option>
					<option value="OR">OR</option>
					<option value="PA">PA</option>
					<option value="RI">RI</option>
					<option value="SC">SC</option>
					<option value="SD">SD</option>
					<option value="TN">TN</option>
					<option value="TX">TX</option>
					<option value="UT">UT</option>
					<option value="VT">VT</option>
					<option value="VA">VA</option>
					<option value="WA">WA</option>
					<option value="WI">WI</option>	
					<option value="WV">WV</option>
					<option value="WY">WY</option>
				</select>		 
        </div>
       
        <div class="activity">
            <label for="activityLevel">Activity Level</label><br>
			<input type="radio" name="activityLevel" value="inactive" checked> Inactive<br>
			<input type="radio" name="activityLevel" value="sedentary"> Sedentary<br>
			<input type="radio" name="activityLevel" value="active"> Active<br>
			<input type="radio" name="activityLevel" value="extremelyActive"> Extremely Active            
        </div>
       
        <div>
            <input type="submit" value="Submit"/>
        </div>
</form:form>
<%@include file="common/footer.jspf"%>
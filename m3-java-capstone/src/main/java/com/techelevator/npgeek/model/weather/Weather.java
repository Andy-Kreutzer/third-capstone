package com.techelevator.npgeek.model.weather;

public class Weather {
	private int low;
	private int high;
	private String forecast;
	private String forecastSuggestion;
	private String tempSuggestion;
	
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public String getForecastSuggestion() {
		return forecastSuggestion;
	}
	
	public void setForecastSuggestion(String forecast) {
		switch (forecast) { 
        case "snow":    
            this.forecastSuggestion = "Remember to pack your snowshoes!";
            break;
        
        case "rain":
        	this.forecastSuggestion = "Remember to pack your rain gear and wear waterproof shoes!";
            break;
        
        case "thunderstorms":
        	this.forecastSuggestion = "Seek shelters and avoid hiking on exposed ridges!";
            break;
        case "sunny":
        	this.forecastSuggestion = "Bring sunblock!";
            break;
		}
	}
	
	public String getTempSuggestion() {
		return tempSuggestion;
	}
	
	public void setTempSuggestion(int high, int low) {
		if (high > 75) {
            this.tempSuggestion = "Bring extra water!"; 
        }
        
        if(high - low > 20) {
        	this.tempSuggestion = "Wear breathable layers!"; 
        }
        
        if(low < 20) {
        	this.tempSuggestion = "Danger! Long time exposures to low temperatures could be damaging!"; 
        }
	}
}

package cl.personal.weatherDemoApp.domain;

public class WeatherCoordinates {

	private double lon;
	private double lat;
	
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "WeatherCoordinates [lon=" + lon + ", lat=" + lat + "]";
	}
	
	
	
}

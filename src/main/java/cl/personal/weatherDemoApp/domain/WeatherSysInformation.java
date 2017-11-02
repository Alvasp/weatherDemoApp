package cl.personal.weatherDemoApp.domain;

public class WeatherSysInformation {

	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "WeatherSysInformation [country=" + country + "]";
	}
	
	
	
}

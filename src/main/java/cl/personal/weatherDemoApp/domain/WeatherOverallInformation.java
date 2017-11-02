package cl.personal.weatherDemoApp.domain;

public class WeatherOverallInformation {

	private double temp;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
	

	@Override
	public String toString() {
		return "WeatherOverallInformation [temp=" + temp + "]";
	}
	
}

package cl.personal.weatherDemoApp.domain;

public class WeatherWindInformation {

	private double speed;

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "WeatherWindInformation [speed=" + speed + "]";
	}
	
	
}

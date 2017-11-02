package cl.personal.weatherDemoApp.domain;

public class WeatherCondition {

	private String id;
	private String name;
	private WeatherCoordinates coord;
	private WeatherOverallInformation main;
	private WeatherWindInformation wind;
	private WeatherSysInformation sys;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WeatherCoordinates getCoord() {
		return coord;
	}
	public void setCoord(WeatherCoordinates coord) {
		this.coord = coord;
	}
	public WeatherOverallInformation getMain() {
		return main;
	}
	public void setMain(WeatherOverallInformation main) {
		this.main = main;
	}
	public WeatherWindInformation getWind() {
		return wind;
	}
	public void setWind(WeatherWindInformation wind) {
		this.wind = wind;
	}
	public WeatherSysInformation getSys() {
		return sys;
	}
	public void setSys(WeatherSysInformation sys) {
		this.sys = sys;
	}
	@Override
	public String toString() {
		return "WeatherCondition [id=" + id + ", name=" + name + ", coord=" + coord + ", main=" + main + ", wind="
				+ wind + ", sys=" + sys + "]";
	}
	
	
	
}

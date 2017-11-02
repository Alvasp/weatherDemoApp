package cl.personal.weatherDemoApp.dao;

import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;

public interface WeatherDAO {

	/**
	 * @param city: cityId
	 * @param units: metric|imperial
	 * @return instancia de weatjerCondition | null si no hay coincidencia
	 * @throws WeatherDemoAppBaseException
	 */
	public WeatherCondition findWeatherCondition( String city, String units ) throws WeatherDemoAppBaseException ;
}

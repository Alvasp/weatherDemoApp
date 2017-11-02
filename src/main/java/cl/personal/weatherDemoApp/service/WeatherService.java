package cl.personal.weatherDemoApp.service;

import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;

public interface WeatherService {

	/**
	 * @param city: cityId
	 * @param units: metric|imperial
	 * @return instancia de weatjerCondition | null si no hay coincidencia
	 * @throws WeatherDemoAppBaseException
	 */
	public WeatherCondition getWeatherCondition(String cityId, String units) throws WeatherDemoAppBaseException;
	
}

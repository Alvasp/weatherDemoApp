package cl.personal.weatherDemoApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.personal.weatherDemoApp.dao.WeatherDAO;
import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;
import cl.personal.weatherDemoApp.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDAO weatherDao;
	
	public WeatherServiceImpl(WeatherDAO weatherDAO) {
		this.weatherDao = weatherDAO;
	}
	
	@Override
	public WeatherCondition getWeatherCondition(String cityId, String units) throws WeatherDemoAppBaseException {
		return weatherDao.findWeatherCondition(cityId, units);
	}

	public WeatherDAO getWeatherDao() {
		return weatherDao;
	}

	public void setWeatherDao(WeatherDAO weatherDao) {
		this.weatherDao = weatherDao;
	}
	

}

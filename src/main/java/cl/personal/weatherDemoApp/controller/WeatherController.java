package cl.personal.weatherDemoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;
import cl.personal.weatherDemoApp.service.WeatherService;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/weather/{cityId}/{units}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<WeatherCondition> getWeatherByCity(@PathVariable("cityId") String city,
			@PathVariable("units") String units) {
		try {
			WeatherCondition weatherCondition = weatherService.getWeatherCondition(city, units);
			HttpStatus httpResponseStatus = (weatherCondition != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

			return new ResponseEntity<WeatherCondition>(weatherCondition, httpResponseStatus);
		} catch (WeatherDemoAppBaseException ex) {
			return new ResponseEntity<WeatherCondition>(HttpStatus.BAD_REQUEST);
		}
	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

}

package cl.personal.weatherDemoApp.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cl.personal.weatherDemoApp.dao.WeatherDAO;
import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;
import cl.personal.weatherDemoApp.util.WeatherDemoAppConfiguration;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

	private WeatherDemoAppConfiguration configuration;
	private RestTemplate restTemplate;
	protected Logger logger = Logger.getLogger(WeatherDAOImpl.class);

	@Autowired
	public WeatherDAOImpl(WeatherDemoAppConfiguration configuration, RestTemplate restTemplate) {
		this.configuration = configuration;
		this.restTemplate = restTemplate;
	}

	@Override
	public WeatherCondition findWeatherCondition(String city, String units) throws WeatherDemoAppBaseException {

		WeatherCondition out;
		String endpoint = configuration.getWeatherAPIEndpoint().replace("{city}", city).replace("{units}", units);
		logger.debug(endpoint);

		try {
			out = restTemplate.getForObject(endpoint, WeatherCondition.class);
			logger.debug("found entity: " + ((out != null) ? out.toString() : "null"));
		} catch (HttpClientErrorException he) {
			if (he.getStatusCode() == HttpStatus.NOT_FOUND) {
				logger.debug("not found entity");
				return null;
			} else {
				throw new WeatherDemoAppBaseException("9998", "endpoint response error", he.getMessage(), he);
			}
		} catch (RestClientException re) {
			throw new WeatherDemoAppBaseException("9999", "endpoint connection error", re.getMessage(), re);
		}

		return out;
	}

	public WeatherDemoAppConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(WeatherDemoAppConfiguration configuration) {
		this.configuration = configuration;
	}
}

package cl.personal.weatherDemoApp.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherDemoAppConfiguration {

	protected Logger logger = Logger.getLogger(WeatherDemoAppConfiguration.class);
	
	@Value("${app.data.weather.endpoint}")
	private String weatherAPIEndpoint;
	
	@Value("${app.data.weather.connectionTimeout.ms}")
	private int weatherAPIConnectionTimeout;
	
	@Value("${app.data.weather.readTimeout.ms}")
	private int weatherAPIReadTimeout;
	
	@Bean
	public RestTemplate restTemplate() {
	 	String endpoint = this.weatherAPIEndpoint;
		Integer connectionTimeout = this.weatherAPIConnectionTimeout;
		Integer readTimeout = this.weatherAPIReadTimeout;
		
		logger.info("weather endpoint URI " + endpoint);
		logger.info("weather endpoint connectionTimeout " + connectionTimeout );
		logger.info("weather endpoint readTimeout " + readTimeout);
		
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectTimeout(connectionTimeout);
		httpRequestFactory.setReadTimeout(readTimeout);
		
		return new RestTemplate(httpRequestFactory);
	}
	
	public String getWeatherAPIEndpoint() {
		return weatherAPIEndpoint;
	}
	public void setWeatherAPIEndpoint(String weatherAPIEndpoint) {
		this.weatherAPIEndpoint = weatherAPIEndpoint;
	}
	public int getWeatherAPIConnectionTimeout() {
		return weatherAPIConnectionTimeout;
	}
	public void setWeatherAPIConnectionTimeout(int weatherAPIConnectionTimeout) {
		this.weatherAPIConnectionTimeout = weatherAPIConnectionTimeout;
	}
	public int getWeatherAPIReadTimeout() {
		return weatherAPIReadTimeout;
	}
	public void setWeatherAPIReadTimeout(int weatherAPIReadTimeout) {
		this.weatherAPIReadTimeout = weatherAPIReadTimeout;
	}	
}

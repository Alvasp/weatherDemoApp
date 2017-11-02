package cl.personal.weatherDemoApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import cl.personal.weatherDemoApp.dao.impl.WeatherDAOImpl;
import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;
import cl.personal.weatherDemoApp.util.WeatherDemoAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeatherDemoAppApplication.class)
public class WeatherDemoAppTests {

	@Autowired
	WeatherDemoAppConfiguration configuration;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private WeatherDAOImpl weatherDAO;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		weatherDAO.setConfiguration(configuration);
	}

	@Test
	public void WeatherDAO_findWeatherCondition_OK() {
		String city = "123";
		String units = "metrics";
		String endpoint = configuration.getWeatherAPIEndpoint().replace("{city}", city).replace("{units}", units);

		WeatherCondition dummyWeatherCondition = new WeatherCondition();
		dummyWeatherCondition.setId("id");
		dummyWeatherCondition.setName("testCity");

		when(restTemplate.getForObject(Matchers.eq(endpoint), Matchers.eq(WeatherCondition.class)))
				.thenReturn(dummyWeatherCondition);

		WeatherCondition daoReturn = null;

		try {
			daoReturn = weatherDAO.findWeatherCondition(city, units);
		} catch (WeatherDemoAppBaseException e) {
			assertTrue(false);
		}
		assertNotNull(daoReturn);
		assertEquals(dummyWeatherCondition.getId(), daoReturn.getId());
		assertEquals(dummyWeatherCondition.getName(), daoReturn.getName());
	}

	@Test
	public void WeatherDAO_findWeatherCondition_NONE() {
		String city = "66x";
		String units = "metrics";
		String endpoint = configuration.getWeatherAPIEndpoint().replace("{city}", city).replace("{units}", units);

		when(restTemplate.getForObject(Matchers.eq(endpoint), Matchers.eq(WeatherCondition.class))).thenReturn(null);

		WeatherCondition daoReturn = null;
		try {
			daoReturn = weatherDAO.findWeatherCondition(city, units);
		} catch (WeatherDemoAppBaseException e) {
			assertTrue(false);
		}

		assertNull(daoReturn);
	}

	@Test
	public void WeatherDAO_findWeatherCondition_ERROR() {
		String city = "ee_rr_oo_rr";
		String units = "metrics";
		String endpoint = configuration.getWeatherAPIEndpoint().replace("{city}", city).replace("{units}", units);

		when(restTemplate.getForObject(Matchers.eq(endpoint), Matchers.eq(WeatherCondition.class)))
				.thenThrow(new RestClientException("error"));

		try {
			WeatherCondition daoReturn = weatherDAO.findWeatherCondition(city, units);
			assertTrue(false);
		} catch (WeatherDemoAppBaseException e) {
			assertTrue(true);
		}

	}

}

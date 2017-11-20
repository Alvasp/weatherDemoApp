

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import cl.personal.weatherDemoApp.WeatherDemoAppApplication;
import cl.personal.weatherDemoApp.dao.impl.WeatherDAOImpl;
import cl.personal.weatherDemoApp.domain.WeatherCondition;
import cl.personal.weatherDemoApp.exception.WeatherDemoAppBaseException;
import cl.personal.weatherDemoApp.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WeatherDemoAppApplication.class)
public class WeatherServiceTest {

	@MockBean
	public WeatherDAOImpl weatherDAOImplMock;
	
	@Autowired
	public WeatherService weatherService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
		
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void getWeatherConditionEntityMatchShouldReturnEntity() throws WeatherDemoAppBaseException {
		WeatherCondition expectedResult = new WeatherCondition();
		expectedResult.setId("123");
		expectedResult.setName("asd");
		when(weatherDAOImplMock.findWeatherCondition("1", "metric")).thenReturn(expectedResult);
	
		WeatherCondition actualResult = this.weatherService.getWeatherCondition("1", "metric");
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getWeatherConditionEntityNoMatchShouldReturnNull() throws WeatherDemoAppBaseException {
		when(weatherDAOImplMock.findWeatherCondition("2", "metric")).thenReturn(null);
		
		assertNull(this.weatherService.getWeatherCondition("2", "metric"));
	}
	
	@Test
	public void getWeatherConditionTechnicalErrorShoudThrowException() throws WeatherDemoAppBaseException {
		when(weatherDAOImplMock.findWeatherCondition("3", "metric")).thenThrow(new WeatherDemoAppBaseException("asd","ddd","fff"));
		
		this.thrown.expect(WeatherDemoAppBaseException.class);

		this.thrown.expect(hasProperty("appErrorCode"));
		this.thrown.expect(hasProperty("appErrorCode",is("asd")));
		
		this.thrown.expect(hasProperty("appErrorMessage"));
		this.thrown.expect(hasProperty("appErrorMessage",is("ddd")));
		
		this.thrown.expect(hasProperty("appErrorDetail"));
		this.thrown.expect(hasProperty("appErrorDetail",is("fff")));
		
		this.weatherService.getWeatherCondition("3", "metric");
		
	}
	
	

}

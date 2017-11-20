

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cl.personal.weatherDemoApp.WeatherDemoAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WeatherDemoAppApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherAppIntegrationTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getWeatherByCityNonExistentCityShouldNotReturnData() {
		ResponseEntity<String> response = this.testRestTemplate
				.getForEntity("/weather/{cityId}/{units}", String.class, new Object[] {"123", "metric"});

		assertThat(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
	}
	
	
	@Test
	public void getWeatherByCityExistentCityShouldReturnData() {
	
		ResponseEntity<String> response = this.testRestTemplate
								.getForEntity("/weather/{cityId}/{units}", String.class, new Object[] {"580881", "metric"});
		
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
	
	}

}

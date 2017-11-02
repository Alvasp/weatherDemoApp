package cl.personal.weatherDemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "cl.personal.weatherDemoApp")
public class WeatherDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDemoAppApplication.class, args);
	}
}

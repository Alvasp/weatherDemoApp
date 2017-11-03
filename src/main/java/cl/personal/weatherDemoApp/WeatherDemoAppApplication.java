package cl.personal.weatherDemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "cl.personal.weatherDemoApp")
public class WeatherDemoAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WeatherDemoAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherDemoAppApplication.class, args);
	}
}

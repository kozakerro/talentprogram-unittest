package dk.bec.autopro.workshop;

import dk.bec.autopro.workshop.connector.WeatherServerConnector;
import dk.bec.autopro.workshop.model.MeasurementInput;
import dk.bec.autopro.workshop.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopApplication {

	public static void main(String[] args) throws IllegalAccessException {
		SpringApplication.run(WorkshopApplication.class, args);

		WeatherService weatherService = new WeatherService(new WeatherServerConnector());

		weatherService.addMeasurement(new MeasurementInput("Warsaw", 20.0));
		weatherService.addMeasurement(new MeasurementInput("Warsaw", 10.0));
		weatherService.addMeasurement(new MeasurementInput("Wroclaw", 30.0));
		weatherService.addMeasurement(new MeasurementInput("Cracow", 25.0));

		double warsawTemp = weatherService.getTemperature("Warsaw");
		System.out.println("Warsaw: " + warsawTemp);
		System.out.println("Warsaw: " + weatherService.isWarm(warsawTemp));

		double olsztynKTemp = weatherService.getTemperatureFromServerInKelvins("Olsztyn");
		System.out.println(String.format("Temperature in Kelvins from server in Olsztyn: %.1f", olsztynKTemp));

		double olsztynCTemp = weatherService.getTemperatureFromServerInCelsius("Olsztyn");
		System.out.println(String.format("Temperature in Celsius from server in Olsztyn: %.1f", olsztynCTemp));
	}

}

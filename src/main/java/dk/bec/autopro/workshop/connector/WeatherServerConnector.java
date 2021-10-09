package dk.bec.autopro.workshop.connector;

import java.util.Random;

/**
 * Dummy weather server connector which returns temperatures in Kelvins
 */
public class WeatherServerConnector {
    private static final double KELVIN_CONSTANT = 273.15;

    public double fetchTemperatureInKelvins(String city) {
        System.out.println("Weather server: Fetching temperature from server...");

        // simulate response time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double tempK = (new Random().nextDouble() - 0.3) * 40 + KELVIN_CONSTANT;
        System.out.println(String.format("Weather server: Retrieved temperature: %.1f K", tempK));
        return tempK;
    }
}

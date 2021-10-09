package dk.bec.autopro.workshop.connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServerConnectorTest {

    private WeatherServerConnector weatherServerConnector = new WeatherServerConnector();

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void shouldFetchTemperatureWithinTimeLimit() {
        weatherServerConnector.fetchTemperatureInKelvins("Warsaw");
    }
}
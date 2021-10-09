package dk.bec.autopro.workshop.connector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeatherServerConnectorTest {

    private WeatherServerConnector weatherServerConnector = new WeatherServerConnector();

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void shouldFetchTemperatureWithinTimeLimit() {
        weatherServerConnector.fetchTemperatureInKelvins("Warsaw");
    }

    @Test
    void testWithMockedConnector() {
        double temp = 20.0;
        WeatherServerConnector connector = Mockito.mock(WeatherServerConnector.class);
        Mockito.when(connector.fetchTemperatureInKelvins(Mockito.any())).thenReturn(temp);
        assertEquals(20.0, connector.fetchTemperatureInKelvins("Warsaw"));

    }
}
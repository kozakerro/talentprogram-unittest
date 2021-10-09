package dk.bec.autopro.workshop.service;

import dk.bec.autopro.workshop.connector.WeatherServerConnector;
import dk.bec.autopro.workshop.matchers.IsCapitalCity;
import dk.bec.autopro.workshop.matchers.IsWarmTemperature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private WeatherServerConnector weatherServerConnector;

    @InjectMocks
    private WeatherService sut = new WeatherService(weatherServerConnector);

    @Test
    void shouldIsWarmReturnTrueWhenTemperatureIsMoreThan20() {
        // given
        double inputTemp = 20;

        // when
        boolean result = sut.isWarm(inputTemp);

        // then
        assertTrue(result);
    }

    @Test
    void shouldIsWarmReturnFalseWhenTemperatureIsLessThan20() {
        // given
        double inputTemp = 10;

        // when
        boolean result = sut.isWarm(inputTemp);

        // then
        assertFalse(result);
    }

    @Test
    void shouldIsColdReturnTrueWhenTemperatureIsLessThan5() {
        // given
        double inputTemp = 5;

        // when
        boolean result = sut.isCold(inputTemp);

        // then
        assertThat("should be true when it's cold", result, is(equalTo(true)));
    }

    @Test
    void shouldThrowExceptionWhenCityDoesntExist() throws IllegalAccessException {
        // given
        String city = "Katowice";

        // when
        Exception ex = assertThrows(IllegalStateException.class,
                () -> sut.getTemperature(city));

        // then
        assertThat(ex.getMessage(), is(equalTo("ss")));
    }

    @Test
    void shouldHaveAllCitiesInMap() {
        assertThat("Data key set contains all cities", sut.getData().keySet(), hasItems("Warsaw", "Cracow", "Wroclaw"));

    }

    @Test
    void testIsWarmMatcher() {
        double warmTemperature = 30.0;
        assertThat(warmTemperature, IsWarmTemperature.warmTemperature());
    }

    @Test
    void shouldFetchProperTempInKelvinsFromServer() {
        // given
        double temp = 20.0;
        Mockito.when(weatherServerConnector.fetchTemperatureInKelvins(Mockito.anyString())).thenReturn(temp);

        // when
        double result = sut.getTemperatureFromServerInKelvins("Paris");

        // then
        assertEquals(temp, result);
    }

    @Test
    void shouldServerConnectorBeCalledThreeTimes() {
        // given
        double temp = 15.0;
        String city = "Cracow";
        Mockito.when(weatherServerConnector.fetchTemperatureInKelvins(Mockito.anyString())).thenReturn(temp);

        // when
        sut.getAverageTemperatureFromServerInKelvinsInThreeCalls(city);

        // then
        Mockito.verify(weatherServerConnector, Mockito.times(3)).fetchTemperatureInKelvins(city);
    }
}
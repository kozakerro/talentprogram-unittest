package dk.bec.autopro.workshop.service;

import dk.bec.autopro.workshop.connector.WeatherServerConnector;
import dk.bec.autopro.workshop.matchers.IsCapitalCity;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.*;


class WeatherServiceTest {

    private WeatherService sut = new WeatherService(new WeatherServerConnector());

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
        assertThat(sut.getData(), hasKey(IsCapitalCity.capitalCity()));
    }
}
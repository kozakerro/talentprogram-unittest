package dk.bec.autopro.workshop.service;

import dk.bec.autopro.workshop.matchers.IsCapitalCity;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.*;


class WeatherServiceTest {

    private WeatherService sut = new WeatherService();

    @Test
    void shouldIsWarmReturnTrueWhenTemperatureIsMoreThan20() {

    }

    @Test
    void shouldIsWarmReturnFalseWhenTemperatureIsLessThan20() {

    }

    @Test
    void shouldIsColdReturnTrueWhenTemperatureIsLessThan5() {

    }

    @Test
    void shouldThrowExceptionWhenCityDoesntExist() throws IllegalAccessException {

    }

    @Test
    void shouldHaveAllCitiesInMap() {

    }
}
package dk.bec.autopro.workshop.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.object.HasToString;
import org.junit.jupiter.api.Test;


class MeasurementInputTest {

    @Test
    void shouldReturnProperToString() {
        MeasurementInput sut = new MeasurementInput("Warsaw", 30.0);

        MatcherAssert.assertThat(sut, HasToString.hasToString("City: Warsaw, temp: 30.0"));
    }

}
package dk.bec.autopro.workshop.model;

import org.hamcrest.number.IsCloseTo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MeasurementHistoryTest {

    @Test
    void testInitialTemperatures() {
        MeasurementHistory sut = new MeasurementHistory();

        // JUnit 5
        assertTrue(sut.getCurrentTemperature() == 0.0, "current temp should be 0.0");
        assertTrue(sut.getAverageTemperature() == 0.0, "average temp should be 0.0");

        // AssertJ
        org.assertj.core.api.Assertions.assertThat(sut.getCurrentTemperature()).describedAs("current temperature").isEqualTo(0.0);
        org.assertj.core.api.Assertions.assertThat(sut.getAverageTemperature()).as("average temperature").isEqualTo(0.0);

        // Hamcrest
        assertThat("current temp",sut.getCurrentTemperature(), allOf(is(IsCloseTo.closeTo(0.0, 0.05))));
        assertThat("average temp", sut.getAverageTemperature(), is(IsCloseTo.closeTo(0.0, 0.05)));

    }

}
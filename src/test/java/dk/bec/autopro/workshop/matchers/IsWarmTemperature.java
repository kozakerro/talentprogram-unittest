package dk.bec.autopro.workshop.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsWarmTemperature extends TypeSafeMatcher<Double> {
    @Override
    protected boolean matchesSafely(Double temp) {
        return temp > 10;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is warm temperature");
    }

    public static Matcher warmTemperature() {
        return new IsWarmTemperature();
    }
}

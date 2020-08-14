package dk.bec.autopro.workshop.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsCapitalCity extends TypeSafeMatcher<String> {
    @Override
    protected boolean matchesSafely(String cityName) {
        return cityName.equalsIgnoreCase("Warsaw");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("is a capital city");
    }

    public static Matcher capitalCity() {
        return new IsCapitalCity();
    }
}

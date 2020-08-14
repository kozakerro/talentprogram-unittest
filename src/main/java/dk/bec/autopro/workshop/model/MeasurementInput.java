package dk.bec.autopro.workshop.model;

public class MeasurementInput {
    private String city;
    private double temperature;

    public MeasurementInput(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "City: " + city + ", temp: " + temperature;
    }
}

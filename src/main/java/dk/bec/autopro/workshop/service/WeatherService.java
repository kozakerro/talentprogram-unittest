package dk.bec.autopro.workshop.service;

import dk.bec.autopro.workshop.connector.WeatherServerConnector;
import dk.bec.autopro.workshop.model.MeasurementHistory;
import dk.bec.autopro.workshop.model.MeasurementInput;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    private Map<String, MeasurementHistory> data;
    private WeatherServerConnector serverConnector;

    public WeatherService(WeatherServerConnector serverConnector) {
        this.serverConnector = serverConnector;
        data = new HashMap<>();
        data.put("Warsaw", new MeasurementHistory());
        data.put("Cracow", new MeasurementHistory());
        data.put("Wroclaw", new MeasurementHistory());
    }

    public Map<String, MeasurementHistory> getData() {
        return data;
    }

    public double getTemperature(String city) throws IllegalStateException {
        MeasurementHistory measurementHistory = data.get(city);
        if (measurementHistory == null) {
            throw new IllegalStateException("City " + city + " doesn't exist");
        }
        return measurementHistory.getCurrentTemperature();
    }

    public double getTemperatureFromServerInKelvins(String city) {
        return serverConnector.fetchTemperatureInKelvins(city);
    }

    public double getTemperatureFromServerInCelsius(String city) {
        double tempInKelvins = serverConnector.fetchTemperatureInKelvins(city);
        return (tempInKelvins - 32) * 5/9;
    }

    public double getAverageTemperature(String city) throws IllegalStateException {
        MeasurementHistory history = data.get(city);
        if (history == null) {
            throw new IllegalStateException("City " + city + " doesn't exist");
        }
        return history.getAverageTemperature();
    }

    public void addCity(String city) {
        this.data.put(city, new MeasurementHistory());
    }

    public void removeCity(String city) {
        this.data.remove(city);
    }

    public boolean isWarm(double temperature) {
        if (temperature >= 20.0) {
            return true;
        }
        return false;
    }

    public boolean isCold(double temperature) {
        if (temperature < 5.0) {
            return true;
        }
        return false;
    }

    public void addMeasurement(MeasurementInput input) throws IllegalStateException {
        MeasurementHistory history = data.get(input.getCity());
        if (history == null) {
            throw new IllegalStateException("City " + input.getCity() + " doesn't exist");
        }
        history.addMeasurement(input.getTemperature());
    }
}

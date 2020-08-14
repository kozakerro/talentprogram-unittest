package dk.bec.autopro.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class MeasurementHistory {
    private double currentTemperature;
    private double averageTemperature;
    private List<Double> measurementsHistory;

    public MeasurementHistory() {
        this.currentTemperature = 0.0;
        this.averageTemperature = 0.0;
        this.measurementsHistory = new ArrayList<Double>();
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void addMeasurement(double temperature) {
        currentTemperature = temperature;
        measurementsHistory.add(temperature);
        recalculateAverageTemperature();
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void resetMeasurements() {
        this.averageTemperature = 0;
        this.measurementsHistory.clear();
    }

    private void recalculateAverageTemperature() {
        this.averageTemperature = measurementsHistory.stream().reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        return "current: " + currentTemperature + ", average: " + averageTemperature;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rr
 */
public class AverageSensor implements Sensor {

    private final List<Sensor> sensors;
    private final List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return this.sensors.stream()
                .noneMatch((sensor) -> (!sensor.isOn()));
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .filter((sensor) -> (!sensor.isOn()))
                .forEachOrdered((sensor) -> {
                    sensor.setOn();
                });
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .filter((sensor) -> (sensor.isOn()))
                .forEachOrdered((sensor) -> {
                    sensor.setOff();
                });
    }

    @Override
    public int read() {
        if (!isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor is off or no sensors have been added");
        }
        int sum = 0;
        sum = this.sensors.stream()
                .map((sensor) -> sensor.read())
                .reduce(sum, Integer::sum);
        this.readings.add(sum/this.sensors.size());
        return sum / this.sensors.size();
    }

    public List<Integer> readings() {
        return this.readings;
    }
}

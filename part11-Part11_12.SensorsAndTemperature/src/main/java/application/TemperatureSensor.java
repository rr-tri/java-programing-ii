/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author rr
 */

public class TemperatureSensor implements Sensor {
    private boolean status;
    private final Random num;
    public TemperatureSensor() {
        this.status = false;
        this.num = new Random();
                
    }

    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void setOn() {
        this.status = true;
    }

    @Override
    public void setOff() {
        this.status = false;
    }

    @Override
    public int read() {
        if(!status){
            throw new IllegalStateException("Temperature sensor is off");
        }
        
        return this.num.nextInt(61) - 30;
    }
    
}

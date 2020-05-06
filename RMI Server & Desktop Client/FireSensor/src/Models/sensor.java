/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;


public class sensor implements Serializable{
    
    public int sensorID;
    public String sensorName;
    public String sensorDescription;
    public int smoke_value;
    public int co2_value;


   public sensor(int sensorID, String sensorName, String sensorDescription,  int smoke_value, int co2_value) {
        this.sensorID = sensorID;
        this.sensorName = sensorName;
        this.sensorDescription = sensorDescription;
        this.smoke_value = smoke_value;
        this.co2_value = co2_value;
    }

    public int getSensorID() {
        return sensorID;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorDescription() {
        return sensorDescription;
    }

    public void setSensorDescription(String sensorDescription) {
        this.sensorDescription = sensorDescription;
    }

    public int getSmoke_value() {
        return smoke_value;
    }

    public void setSmoke_value(int smoke_value) {
        this.smoke_value = smoke_value;
    }

    public int getCo2_value() {
        return co2_value;
    }

    public void setCo2_value(int co2_value) {
        this.co2_value = co2_value;
    }
   
}
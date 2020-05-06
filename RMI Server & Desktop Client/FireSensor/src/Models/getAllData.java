/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;


public class getAllData implements Serializable{
    
    private String id;
    private String floor;
    private String sensor;
    private String smoke_level;
    private String co2_level;
    private String room;
    private String status_val;
    private String status_color;
    
    
     public getAllData( String id,String floor, String sensor, String smoke_level, String co2_level, String room ) {
         
        this.id=id;
        this.floor = floor;
        this.sensor = sensor;
        this.smoke_level = smoke_level;
        this.co2_level = co2_level;
        this.room = room;
       
       
         
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

 

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getSmoke_level() {
        return smoke_level;
    }

    public void setSmoke_level(String smoke_level) {
        this.smoke_level = smoke_level;
    }

    public String getCo2_level() {
        return co2_level;
    }

    public void setCo2_level(String co2_level) {
        this.co2_level = co2_level;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStatus_val() {
        return status_val;
    }

    public void setStatus_val(String status_val) {
        this.status_val = status_val;
    }

    public String getStatus_color() {
        return status_color;
    }

    public void setStatus_color(String status_color) {
        this.status_color = status_color;
    }
    
}

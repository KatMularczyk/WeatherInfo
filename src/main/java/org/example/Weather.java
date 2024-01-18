package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    private String city;
    private Double temp, pressure, humidity;

    public Weather(){
    }
    public Weather(List<Double> tph, String c){
        this.temp = tph.get(0);
        this.pressure = tph.get(1);
        this.humidity = tph.get(2);
        this.city = c;
    }

    public Double getHumidity() {
        return humidity;
    }
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String printWeather(){
        String txt = String.format("W %s jest %.2f stopni, %2f press, %.2f humidity", city, temp, pressure, humidity);
        System.out.println(txt);
        return txt;
    }



}

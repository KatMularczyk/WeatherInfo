package org.example;

public class City {

    private String name;
    public String getName(){    return this.name;   }
    private Double[] coordinates;
    public Double[] getCoordinates(){   return this.coordinates;    }

    public City (String name, Double[] coordinates){
        this.name = name;
        this.coordinates = coordinates;
    }
    public City (){
        this.name = "";
        this.coordinates = new Double[]{0.0, 0.0};
    }



}

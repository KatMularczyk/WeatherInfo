package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private String path;
    private List<City> cities = new ArrayList<>();
    public Reader(String path){
        this.path = path;
    }

    public void listCreator()
    {
        File input = new File(path); //forward the file to parse

        JsonElement fileElement;
        {
            try {
                //parsing into an array of elements - cities
                fileElement = JsonParser.parseReader(new FileReader(input));
                JsonArray jsonArrayOfCities = fileElement.getAsJsonArray();

                /*List<City> cities = new ArrayList<>();*/

                for (JsonElement city : jsonArrayOfCities) {
                    //get each city as an object
                    JsonObject cityElement = city.getAsJsonObject();
                    String name = cityElement.get("city").getAsString();
                    //get its coord into an array
                    Double la = cityElement.get("latitude").getAsDouble();
                    Double lo = cityElement.get("longitude").getAsDouble();
                    Double[] coordinates = {la, lo};
                    //create new object ans adds it to a list of objects
                    City c = new City(name, coordinates);
                    cities.add(c);

                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Double[] searcher(String cityName){
        Double[] toReturn = new Double[2];
        for(City city : cities){
            if(city.getName().contains(cityName)){
                toReturn = Arrays.copyOf(city.getCoordinates(),city.getCoordinates().length);
            }
        }
        return toReturn;
    }

}

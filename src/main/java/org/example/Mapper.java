package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Mapper {

public Mapper(String la, String lo){
    this.lat = la;
    this.lon = lo;
}

private String curWeather, lat = "51.45", lon="18.05";
    public String getLat() {        return lat;    }
    public void setLat(String newLat) {        this.lat = newLat;   }
    public String getLon() {        return lon;    }
    public void setLon(String newLon) {        this.lon = newLon;   }

public String getResponse(Mapper coord /*String lat, String lon*/){
        String lat = coord.getLat();
        String lon = coord.getLon();
    String uri = String.join("",
            "https://api.openweathermap.org/data/2.5/weather?lat=",
            lat,
            "&lon=",
            lon,
            "&units=metric&appid=ab9cb50752b81413a5339c0b719d3b03");
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
    return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .join();
}
public List<Double> jsonToList(String curW){

    JsonElement element;
    element = JsonParser.parseString(curW);
    JsonObject data = element.getAsJsonObject();
    JsonObject mainData = data.get("main").getAsJsonObject();
    List<Double> neededDataList = new ArrayList<>();
    neededDataList.add(mainData.get("temp").getAsDouble());
    neededDataList.add(mainData.get("pressure").getAsDouble());
    neededDataList.add(mainData.get("humidity").getAsDouble());
    System.out.println(Arrays.toString(neededDataList.toArray()));
    return neededDataList;



}
/*public String[] punctRemover(String curW){
    String[] weatherArray = curW.replace(':',' ').split(",");
    int i=0;
    for(String element :weatherArray){
        weatherArray[i]=weatherArray[i].replace('.','x');
        weatherArray[i]=weatherArray[i].replaceAll("[^\\sa-zA-Z0-9]"," ");
        weatherArray[i]=weatherArray[i].replace('x',',');
        i=i+1;
    }
    return weatherArray;
}

public Map extractor(String[] array){
    Map<String,String> weatherMap = new TreeMap<>();
    for(String element :array) {
        String[] pair = new String[2];// arrays of diff weather info

        element = element.trim();
        pair[0]=element.substring(0,element.lastIndexOf(" "));
        pair[1]=element.substring(element.lastIndexOf(" "));

        pair[0]=pair[0].trim();
        if (*//*pair[0].equals("main    temp")*//*pair[0].contains("main")&&pair[0].contains("temp")){
            weatherMap.put("Temperature:",pair[1]);
        }
        if (*//*pair[0].equals("pressure")*//*pair[0].contains("pressure")){
            weatherMap.put("Pressure:",pair[1]);
        }
        if (*//*pair[0].equals("humidity")*//*pair[0].contains("humidity")){
            weatherMap.put("Humidity:",pair[1]);
        }
    }
    return weatherMap;
}*/

}

package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Lister {

public Lister(Double la, Double lo){
    this.lat = la;
    this.lon = lo;
}

private String curWeather;
private Double lat, lon;
    public Double getLat() {        return lat;    }
    public void setLat(Double newLat) {        this.lat = newLat;   }
    public Double getLon() {        return lon;    }
    public void setLon(Double newLon) {        this.lon = newLon;   }

public String getResponse(Lister coord){
    Double lat = coord.getLat();
    Double lon = coord.getLon();
    String uri = String.join("",
            "https://api.openweathermap.org/data/2.5/weather?lat=",
            lat.toString(),
            "&lon=",
            lon.toString(),
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


}

package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.openweathermap.org/data/2.5/weather?lat=51.45&lon=18.05&units=metric&appid=ab9cb50752b81413a5339c0b719d3b03")).build();
        String curWeather = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenAccept(System.out::println)
                .join();

        String[] weatherArray = curWeather.replace(':',' ').split(",");
        int i=0;
        for(String element :weatherArray){
            weatherArray[i]=weatherArray[i].replace('.','x');
            weatherArray[i]=weatherArray[i].replaceAll("[^\\sa-zA-Z0-9]"," ");
            weatherArray[i]=weatherArray[i].replace('x',',');
            i=i+1;
        }
        i=0;

        Map<String,String> weatherMap = new TreeMap<>();
        for(String element :weatherArray) {
            System.out.println(element);
            String[] pair = new String[2];
            element = element.trim();
            pair[0]=element.substring(0,element.lastIndexOf(" "));
            pair[1]=element.substring(element.lastIndexOf(" "));
            System.out.println(pair[0]);
            pair[0]=pair[0].trim();
            if (pair[0].equals("main    temp")){
                weatherMap.put("Temperature:",pair[1]);
            }
            if (pair[0].equals("pressure")){
                weatherMap.put("Pressure:",pair[1]);
            }
            if (pair[0].equals("humidity")){
                weatherMap.put("Humidity:",pair[1]);
            }
        }

        Set<String> keySet = weatherMap.keySet();
        System.out.println("Klucze:\n" + keySet);
        Collection<String> values = weatherMap.values();
        System.out.println("Wartości:\n" + values);
    }
}
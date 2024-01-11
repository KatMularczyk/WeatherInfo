package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Decision decision = new Decision();
        System.out.print("Hello and welcome!");
        List<Weather> listOfResponses = new ArrayList<>();
        //make a list o cities with coords
        Reader reader = new Reader("C:\\Users\\lenovo\\IdeaProjects\\Weather_forecast\\src\\main\\resources\\cities.json");
        reader.listCreator();

        while(decision.getI()==1) {

            String input = decision.start();
            System.out.println("Works");
            //check the coordinates of given city and put them into an array
            Double[] coordArray = reader.searcher(input);
            //forwards the coords to Lister to get the weather from API
            Lister cityWeather = new Lister(coordArray[0], coordArray[1]);
            List<Double> weatherList = new ArrayList<>();
            weatherList = cityWeather.
                    jsonToList(cityWeather.
                            getResponse(cityWeather));
            //creating a weather object to put it on the list
            Weather weather = new Weather(weatherList, input);
            listOfResponses.add(weather);
            decision.question();
        }
        listOfResponses.stream().forEach(e -> e.printWeather());
        Info info = new Info();
        info.createJson(listOfResponses);
    }
}
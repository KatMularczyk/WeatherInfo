package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");
        //make a list o cities with coords
        Reader reader = new Reader("C:\\Users\\lenovo\\IdeaProjects\\Weather_forecast\\src\\main\\resources\\cities.json");
        reader.listCreator();

        //get the input - city name
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //check the coordinates of given city and put them into an array
        Double[] coordArray = reader.searcher(input);
        Double la = coordArray[0];
        Double lo = coordArray[1];
        //forwards the coords to Lister to get the weather from API
        Lister city = new Lister(la, lo);
        List<Double> weatherList = new ArrayList<>();
        weatherList = city.
                jsonToList(city.
                        getResponse(city));


    }
}
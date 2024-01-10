package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        Reader reader = new Reader("C:\\Users\\lenovo\\IdeaProjects\\Weather_forecast\\src\\main\\resources\\cities.json");
        reader.listCreator();
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string " + s);
        Double[] y = reader.searcher(s);

        String la = y[0].toString();
        String lo = y[1].toString();
        System.out.print(la);
        System.out.print(lo);

        Map x = new TreeMap();
        Mapper city = new Mapper(la, lo);
        x = city.
                extractor(
                city.punctRemover(
                city.getResponse(city)));

        Set keySet = x.keySet();
        System.out.println("Klucze:\n" + keySet);
        Collection values = x.values();
        System.out.println("Wartości:\n" + values);

    }
}
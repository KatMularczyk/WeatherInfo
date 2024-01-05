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
        Map x = new TreeMap();
        Mapper city = new Mapper("51.45", "18.05");
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
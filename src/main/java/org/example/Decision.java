package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decision {
    private int i=1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    Scanner in = new Scanner(System.in);
    public Decision(){
    }

    public String start(){
        System.out.print("Enter the city");
        //get the input - city name
        String input = in.nextLine();
        return input;
    }

    public void question(){
        System.out.println("Do you want to continue? y/n");
        String userDecision = in.nextLine();
        while(!(userDecision.equalsIgnoreCase("n")|userDecision.equalsIgnoreCase("y"))){
            System.out.println("Do you want to continue? y/n");
            userDecision = in.nextLine();
        }
        if(userDecision.equalsIgnoreCase("n")){
            i=0;
        }

    }
    public String createJson(List<Weather> list){

        Gson gson = new Gson();
        String json = gson.toJson(list);
        try {
            FileWriter writer = new FileWriter("WeatherList.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);
        return json;
    }

    /*public void whenToXmlFile() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("simple_bean.xml"), new SimpleBean());
        File file = new File("simple_bean.xml");

    }*/



}

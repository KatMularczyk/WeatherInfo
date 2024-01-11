package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

public class Info {

    public Info(){

    }
    public String createJson(List<Weather> list){

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }

}

package com.example.exampractice;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class JsonUtility {

    // Reader from the JSON file
    public static Dealership getDealershipFromFile(){
        Dealership dealership = null;

        try(
                FileReader fileReader = new FileReader("carData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            dealership = gson.fromJson(jsonReader, Dealership.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return dealership;
    }
}

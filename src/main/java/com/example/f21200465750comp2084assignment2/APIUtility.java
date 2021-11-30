package com.example.f21200465750comp2084assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class APIUtility {

    public static  ApiResponse getAirportJsonfile()
    {


        Gson gson = new Gson();
        ApiResponse response = null;

        try (
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }


}

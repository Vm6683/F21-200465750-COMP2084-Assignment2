package com.example.f21200465750comp2084assignment2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {

 /*
        // This method stores Json file in our local machine and then returns on GUI.
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
*/
        // This method returns response directly from API
    public static ApiResponse getAirportsFromAPI(String searchTerm)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://aerodatabox.p.rapidapi.com/airports/search/term?q="+ searchTerm))
                .header("x-rapidapi-host", "aerodatabox.p.rapidapi.com")
                .header("x-rapidapi-key", "009bfd70c5msh425674fe5331d9bp1fbb4bjsn72d0db0eb5b8")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String jsonString = response.body();

        Gson gson = new Gson();
        ApiResponse apiResponse = null;

        try{
            apiResponse = gson.fromJson(jsonString, ApiResponse.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return apiResponse;

    }

    public static AirportDetails getAirportDetailsFromAPI(String iata) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airport-info.p.rapidapi.com/airport?iata="+ iata))
                .header("x-rapidapi-host", "airport-info.p.rapidapi.com")
                .header("x-rapidapi-key", "009bfd70c5msh425674fe5331d9bp1fbb4bjsn72d0db0eb5b8")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response  = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body();

        Gson gson = new Gson();
        AirportDetails airportDetails = null;

        try{
            airportDetails = gson.fromJson(jsonString, AirportDetails.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return airportDetails;
    }
}

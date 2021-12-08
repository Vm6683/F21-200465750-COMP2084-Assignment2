package com.example.f21200465750comp2084assignment2.Utilities;
import com.example.f21200465750comp2084assignment2.AirportDetails;
import com.example.f21200465750comp2084assignment2.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
    /**
     * This method stores Json file in our local machine and then returns on GUI. I used it for get response in console.
     * */
    /*
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

    /**
     * This method will call AeroDataBox API and gets response directly from API. It uses parameter searchterm to get response.
     * @param searchTerm
     * @return
     */
    public static ApiResponse getAirportsFromAPI(String searchTerm) {
        searchTerm = searchTerm.trim().replace(" ", "%20");
        /** This code snippets is provided by RapidAPI **/
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://aerodatabox.p.rapidapi.com/airports/search/term?q=" + searchTerm))
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

        try {
            apiResponse = gson.fromJson(jsonString, ApiResponse.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return apiResponse;
    }
    /**
     * This method will call Airport info API and gets response directly from API.
     * It uses parameter iata from Airport class to get response.
     * @param iata
     * @return
     */
    public static AirportDetails getAirportDetailsFromAPI(String iata) {
        /** This code snippets is provided by RapidAPI **/
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airport-info.p.rapidapi.com/airport?iata=" + iata))
                .header("x-rapidapi-host", "airport-info.p.rapidapi.com")
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
        AirportDetails airportDetails = null;
        try {
            airportDetails = gson.fromJson(jsonString, AirportDetails.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return airportDetails;
    }
}
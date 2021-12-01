package com.example.f21200465750comp2084assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

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


    public static ApiResponse getAirportsFromAPI(String searchTerm)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://aerodatabox.p.rapidapi.com/airports/search/term?q="+ searchTerm))
                .header("x-rapidapi-host", "aerodatabox.p.rapidapi.com")
                .header("x-rapidapi-key", "009bfd70c5msh425674fe5331d9bp1fbb4bjsn72d0db0eb5b8")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());



      /**
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airport-info.p.rapidapi.com/airport?iata=" + searchTerm))
                .header("x-rapidapi-host", "airport-info.p.rapidapi.com")
                .header("x-rapidapi-key", "009bfd70c5msh425674fe5331d9bp1fbb4bjsn72d0db0eb5b8")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<Path> response1 = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       */
       return getAirportJsonfile();
    }



}

package com.example.f21200465750comp2084assignment2;

public class Main {

    public static void main(String[] args) {
        ApiResponse result = APIUtility.getAirportsFromAPI("Oshawa");
        System.out.println(result);
    }

}

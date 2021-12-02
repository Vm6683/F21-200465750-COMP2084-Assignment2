package com.example.f21200465750comp2084assignment2;


public class ApiResponse {

    private Airport[] items;

    private  AirportDetails[] airportDetails;

    public AirportDetails[] getAirportDetails() {
        return airportDetails;
    }

    public void setAirportDetails(AirportDetails[] airportDetails) {
        this.airportDetails = airportDetails;
    }

    public Airport[] getItems() {
        return items;
    }


    public void setItems(Airport[] items) {
        this.items = items;
    }
}
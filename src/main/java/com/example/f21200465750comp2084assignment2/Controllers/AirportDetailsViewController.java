package com.example.f21200465750comp2084assignment2.Controllers;

import com.example.f21200465750comp2084assignment2.APIUtility;
import com.example.f21200465750comp2084assignment2.AirportDetails;
import com.example.f21200465750comp2084assignment2.ApiResponse;
import com.example.f21200465750comp2084assignment2.Urls;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class AirportDetailsViewController {

    @FXML
    private Label continentLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label iataLabel;

    @FXML
    private Label icaolabel;

    @FXML
    private Label localTimeLabel;

    @FXML
    private Label shortNameLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private ListView<Urls> urlsListView;



    public void getAirportDetails(){

        ApiResponse airportDetails = APIUtility.getAirportDetailsFromAPI();

        if (airportDetails.getItems() != null) {
            icaolabel.getText();

        }
        }

       /*AirportDetails airportDetails = null;
        airportDetails = APIUtility.getAirportDetailsFromAPI();
        icaolabel.setText(airportDetails.getIcao());
        iataLabel.setText(airportDetails.getIata());
        shortNameLabel.setText(airportDetails.getShortName());
        fullNameLabel.setText(airportDetails.getFullName());
        timeZoneLabel.setText(String.valueOf(airportDetails.getTimeZone()));
        localTimeLabel.setText(String.valueOf(airportDetails.getLocalTime()));
        countryLabel.setText(String.valueOf(airportDetails.getCountry()));
        continentLabel.setText(String.valueOf(airportDetails.getContinents()));*/


    }
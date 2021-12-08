package com.example.f21200465750comp2084assignment2.Controllers;

import com.example.f21200465750comp2084assignment2.APIUtility;
import com.example.f21200465750comp2084assignment2.AirportDetails;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;


public class AirportDetailsViewController implements Initializable {

    @FXML
    private Label cityLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label iataLabel;

    @FXML
    private Label icaoLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label streetNumberLabel;

    @FXML
    private Label websiteLabel;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAirportDetails("yyz");
    }
    public void loadAirportDetails(String iataCode){
        AirportDetails airportDetails = null;
        airportDetails = APIUtility.getAirportDetailsFromAPI(iataCode);

        iataLabel.setText(airportDetails.getIata());
        icaoLabel.setText(airportDetails.getIcao());
        nameLabel.setText(airportDetails.getName());
        streetNumberLabel.setText(airportDetails.getStreet_number());
        streetLabel.setText(airportDetails.getStreet());
        cityLabel.setText(airportDetails.getCity());
        countryLabel.setText(airportDetails.getCountry());
        postalCodeLabel.setText(airportDetails.getPostal_code());
        phoneLabel.setText(airportDetails.getPhone());
        websiteLabel.setText(airportDetails.getWebsite());
    }
}




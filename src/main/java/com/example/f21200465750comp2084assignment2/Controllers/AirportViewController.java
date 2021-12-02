package com.example.f21200465750comp2084assignment2.Controllers;

import com.example.f21200465750comp2084assignment2.APIUtility;
import com.example.f21200465750comp2084assignment2.Airport;
import com.example.f21200465750comp2084assignment2.ApiResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirportViewController {

    @FXML
    private ListView<Airport> initialAirportDataListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label errorMsgLabel;

    @FXML
    public void getSearchResults() {
        initialAirportDataListView.getItems().clear();
        errorMsgLabel.setVisible(false);

        ApiResponse apiResponse = APIUtility.getAirportsFromAPI(searchTextField.getText());
        if (apiResponse.getItems() != null) {
            initialAirportDataListView.getItems().addAll(apiResponse.getItems());
        } else {
            errorMsgLabel.setVisible(true);

        }
    }
}
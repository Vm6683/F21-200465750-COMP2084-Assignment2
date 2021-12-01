package com.example.f21200465750comp2084assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AirportViewController {

    @FXML
    private ListView<Airport> initialAirportDataListView;

    @FXML
    private TextField searchTextField;

    @FXML
    public void getSearchResults() {
        initialAirportDataListView.getItems().clear();

        ApiResponse apiResponse = APIUtility.getAirportsFromAPI(searchTextField.getText());
        if (apiResponse.getItems() != null) {
        
            initialAirportDataListView.getItems().addAll(apiResponse.getItems());
            setAirportFound();
        } else {

        }
    }

    private void setAirportFound() {
    }
}
package com.example.f21200465750comp2084assignment2.Controllers;
import com.example.f21200465750comp2084assignment2.Utilities.APIUtility;
import com.example.f21200465750comp2084assignment2.Airport;
import com.example.f21200465750comp2084assignment2.ApiResponse;
import com.example.f21200465750comp2084assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AirportViewController implements Initializable {

    @FXML
    private ListView<Airport> initialAirportDataListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label errorMsgLabel;

    /**
     * This initializes initial view.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorMsgLabel.setVisible(false);
    }

    /**
     * This method will give response when user enter city name into text field
     * or else it will show error message if city name is incorrect.
     */
    @FXML
    public void getSearchResults() {
        errorMsgLabel.setVisible(false);
        initialAirportDataListView.getItems().clear();
        errorMsgLabel.setVisible(false);
        ApiResponse apiResponse = APIUtility.getAirportsFromAPI(searchTextField.getText());
        if (apiResponse.getItems() != null) {
            initialAirportDataListView.getItems().addAll(apiResponse.getItems());
        } else {
            errorMsgLabel.setVisible(true);
        }
    }
    /**
     * This method refers to SceneChanger class. It changes scene when user clicks on Get details Button.
      * @param event
     * @throws IOException
     */
    @FXML
    private  void getAirportDetails(ActionEvent event) throws IOException {
        String iataCode = initialAirportDataListView.getSelectionModel().getSelectedItem().getIata();
        SceneChanger.changeScenes(event, "airport-details-view.fxml", iataCode
        );
    }
}
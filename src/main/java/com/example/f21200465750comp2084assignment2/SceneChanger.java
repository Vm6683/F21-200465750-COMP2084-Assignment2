package com.example.f21200465750comp2084assignment2;

import com.example.f21200465750comp2084assignment2.Controllers.AirportDetailsViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

         public static void changeScenes (ActionEvent event, String fxmlFile,String iataCode) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
             Scene scene = new Scene(fxmlLoader.load());

             AirportDetailsViewController controller = fxmlLoader.getController();
             controller.loadAirportDetails(iataCode);
             Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         }
}

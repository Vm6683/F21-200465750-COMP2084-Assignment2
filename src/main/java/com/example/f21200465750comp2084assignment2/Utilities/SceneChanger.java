package com.example.f21200465750comp2084assignment2.Utilities;
import com.example.f21200465750comp2084assignment2.InitializeAirport;
import com.example.f21200465750comp2084assignment2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneChanger {
    /**
     * This method gets IATA code from Airport class and uses it as search term to get response from API for next scene.
     * @param event
     * @param fxmlFile
     * @param iataCode
     * @throws IOException
     */
         public static void changeScenes (ActionEvent event, String fxmlFile,String iataCode) throws IOException {
             FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
             Scene scene = new Scene(fxmlLoader.load());
             /**
              * This refers to intialize airport interface.
              */
             InitializeAirport controller = fxmlLoader.getController();
             controller.loadAirportDetails(iataCode);
             Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         }
    /**
     * This method redirect user to main page by get FXML file location.
     * @param event
     * @param fxmlFile
     * @throws IOException
     */
        public static void changeScenes (ActionEvent event, String fxmlFile) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
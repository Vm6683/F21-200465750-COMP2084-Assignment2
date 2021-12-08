package com.example.f21200465750comp2084assignment2;

import  javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("airport-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search any airport !");
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
module com.example.f21200465750comp2084assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires javafx.graphics;
    requires com.google.gson;

    opens com.example.f21200465750comp2084assignment2 to javafx.fxml,com.google.gson;
    exports com.example.f21200465750comp2084assignment2;
}
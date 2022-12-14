module com.example.exampractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.exampractice to javafx.fxml, com.google.gson;
    exports com.example.exampractice;
}
package com.example.exampractice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.CurrencyStringConverter;

import java.net.URL;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    @FXML
    private ListView<Car> listView;

    @FXML
    private Label msgLabel;


    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private Label dealershipName;

    @FXML
    private Label inventoryValueLabel;

    @FXML
    private Label numberOfCars;

    @FXML
    private Label idLabel;


    @FXML
    private Label makeLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private GridPane carDetailGridPane;

    @FXML
    void getDetails(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dealership dealership = JsonUtility.getDealershipFromFile();

        dealershipName.setText(dealership.getDealership());

        listView.getItems().addAll(dealership.getInventory());

        carDetailGridPane.setVisible(false);

        inventoryValueLabel.setText(String.format("Inventory Value: %s", getTotalValueOfCars()));
        //if I want to use decimal places for string format use %.2f for 2 decimal places

        //Update details whenever a car in the list is clicked
        listView.getSelectionModel().selectedItemProperty().addListener((obs,old,selectedCar)->{
            if (selectedCar != null)
            {
                carDetailGridPane.setVisible(true);
                idLabel.setText(String.valueOf(selectedCar.getId()));
                yearLabel.setText(String.valueOf(selectedCar.getYear()));
                makeLabel.setText(selectedCar.getMake());
                modelLabel.setText(selectedCar.getModel());
                priceLabel.setText(String.valueOf(selectedCar.getPrice()));
                typeLabel.setText(selectedCar.getType());
            }
        });
    }


    /**
     * This will return the number of items in the list ...number of cars in the list
     */
    public int getCarsInList(){
        return listView.getItems().size();
    }


    /**
     * This will return the price of all of the cars in the list using streams
     */

    public String getTotalValueOfCars(){
        double invValue =  listView.getItems()
                .stream()
                .mapToDouble(Car::getPrice)
                .sum();

        CurrencyStringConverter csc = new CurrencyStringConverter(Locale.CANADA);
        return csc.toString(invValue);
    }


    /**
     * get the average price of the cars
     */

    public String getAveragePrice(){
        String averagePrice;
        OptionalDouble avgPrice = listView.getItems()
                .stream()
                .mapToDouble(Car::getPrice)
                .average();
        CurrencyStringConverter csc = new CurrencyStringConverter(Locale.CANADA);

        //lambda for true false
        return "AvgPrice: " + (avgPrice.isPresent()? csc.toString(avgPrice.getAsDouble()) : "N/A");
    }
}

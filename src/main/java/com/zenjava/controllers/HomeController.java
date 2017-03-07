package com.zenjava.controllers;


import com.zenjava.MainApp;
import com.zenjava.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;



/**
 * Controller of the home page of the store
 */
public class HomeController {

    @FXML
    private ListView<Product> listView;

    @FXML
    private Label productName;

    @FXML
    private Label productDescription;

    @FXML
    private Label productPrice;

    @FXML
    private ChoiceBox<String> choiceBox;

    private MainApp mainApp;

    public HomeController() {
    }

    @FXML
    private void initialize() {
    }

    public void showProductDetails(Product product) {
        productName.setText(product.getName());
        productDescription.setText(product.getDescription());
        productPrice.setText(Integer.toString(product.getPrice()));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        listView.setItems(mainApp.getObservableList());
    }


}

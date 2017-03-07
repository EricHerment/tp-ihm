package com.zenjava.controllers;


import com.zenjava.MainApp;
import com.zenjava.model.Product;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

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

    @FXML
    private ImageView productImage;

    private MainApp mainApp;

    public HomeController() {
    }

    @FXML
    private void initialize() {
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                showProductDetails(newValue);
            }
        });

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
    }

    private void showProductDetails(Product product) {
        productName.setText(product.getName());
        productDescription.setText(product.getDescription());
        productPrice.setText(Integer.toString(product.getPrice()));
        productImage.setImage(product.getImage());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        listView.setItems(mainApp.getObservableList());
        choiceBox.setItems(mainApp.getChoiceList());
        choiceBox.setValue(mainApp.getChoiceList().get(0));
    }
}

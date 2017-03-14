package com.zenjava.controllers;


import com.zenjava.MainApp;
import com.zenjava.model.Product;
import com.zenjava.util.ProductCellFactory;
import com.zenjava.util.ProductParser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

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

    @FXML
    private Button contactButton;

    @FXML
    private void initialize() {
        ObservableList<Product> productsList = FXCollections.observableArrayList();
        ObservableList<String> choiceList = FXCollections.observableArrayList();

        try {
            productsList.setAll(new ProductParser().getProducts());
            choiceList.setAll(new ProductParser().getCategories());
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView.setItems(productsList);
        listView.setCellFactory(new ProductCellFactory());
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                showProductDetails(newValue);
            }
        });

        choiceBox.setItems(choiceList);
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ObservableList<Product> newList = FXCollections.observableArrayList();
                for (Product product : productsList) {
                    if (product.getCategory().equals(newValue))
                        newList.add(product);
                }
                listView.setItems(newList);
            }
        });

    }

    @FXML
    public void handleButtonAction() throws IOException {
        String fxmlFile = "/fxml/contact_view.fxml";
        FXMLLoader loader = new FXMLLoader();
        Scene scene = new Scene(loader.load(getClass().getResourceAsStream(fxmlFile)),600,400);
        Stage stage = new Stage();
        stage.setTitle("Contact");
        stage.setScene(scene);
        stage.show();
    }

    private void showProductDetails(Product product) {
        productName.setText(product.getName());
        productDescription.setText(product.getDescription());
        productPrice.setText(product.getPrice());
        File file = new File(product.getImage());
        Image image = new Image(file.toString());
        productImage.setImage(image);
    }
}

package com.zenjava.controllers;


import com.zenjava.MainApp;
import com.zenjava.model.Product;
import com.zenjava.util.ProductCellFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
                if (newValue.equals("Categorie 2"))
                    productName.setText("WESH");
            }
        });

    }

    private void showProductDetails(Product product) {
        //Faire un appel a la vue a la place
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
        listView.setCellFactory(new ProductCellFactory());
        choiceBox.setItems(mainApp.getChoiceList());
        choiceBox.setValue(mainApp.getChoiceList().get(0));
    }

    @FXML
    public void handleButtonAction() throws IOException {
        String fxmlFile = "/fxml/contact_view.fxml";
        FXMLLoader loader = new FXMLLoader();
        Scene scene2 = new Scene(loader.load(getClass().getResourceAsStream(fxmlFile)),1200,800);
        Stage stage = new Stage();
        stage.setTitle("contact");
        stage.setScene(scene2);
        stage.show();
    }
}

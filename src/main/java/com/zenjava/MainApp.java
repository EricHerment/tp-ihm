package com.zenjava;

import com.zenjava.controllers.HomeController;
import com.zenjava.model.Product;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Product> observableList = FXCollections.observableArrayList();

    public MainApp() {
        observableList.add(new Product("Produit", "lol", new SimpleIntegerProperty(100)));
    }

    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Home Page");

        initLayout();
    }

    private void initLayout() {
        try {
            String fxmlFile = "/fxml/home_view.fxml";
            FXMLLoader loader = new FXMLLoader();
            rootLayout = loader.load(getClass().getResourceAsStream(fxmlFile));

            Scene scene = new Scene(rootLayout, 1100, 800);
            //scene.getStylesheets().add("/styles/styles.css");
            primaryStage.setScene(scene);
            primaryStage.show();

            HomeController homeController = loader.getController();
            homeController.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public ObservableList<Product> getObservableList() {
        return observableList;
    }
}

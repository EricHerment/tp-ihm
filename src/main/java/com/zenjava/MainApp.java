package com.zenjava;

import com.zenjava.controllers.HomeController;
import com.zenjava.model.Product;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Product> listView = FXCollections.observableArrayList();
    private ObservableList<String> choiceList = FXCollections.observableArrayList();

    public MainApp() {
        listView.add(new Product("Ceci est le nom du produit", "Ceci est la description du produit", new SimpleIntegerProperty(100),
                new Image(getClass().getResourceAsStream("/images/google_pixel.png")), "Categorie 1"));
        listView.add(new Product("Ceci est le nom du produit bis", "Ceci est la description du produit bis", new SimpleIntegerProperty(200),
                new Image(getClass().getResourceAsStream("/images/one_plus3.jpg")), "Categorie 1"));
        choiceList.add("Categorie 1");
        choiceList.add("Categorie 2");
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

            Scene scene = new Scene(rootLayout, 1200, 800);
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
        return listView;
    }

    public ObservableList<String> getChoiceList() {
        return choiceList;
    }
}

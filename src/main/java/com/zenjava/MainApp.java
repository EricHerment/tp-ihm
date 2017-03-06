package com.zenjava;

import com.zenjava.model.Product;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.applet.Main;

public class MainApp extends Application {

    private ObservableList<Product> observableList = FXCollections.observableArrayList();

    public MainApp() {
        observableList.add(new Product("Produit", "lol", new SimpleIntegerProperty(100)));
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/home_view.fxml";

        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        Scene scene = new Scene(rootNode, 1100, 800);
        //scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Home page");
        stage.setScene(scene);
        stage.show();
    }
}

package com.zenjava.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;



/**
 * Controller of the home page of the store
 */
public class HomeController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Label productName;

    @FXML
    private Label productDescription;

    @FXML
    private Label productPrice;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    public void initialize() {

    }


}

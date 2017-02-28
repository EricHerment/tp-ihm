package com.zenjava;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 25/02/2017.
 */
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

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
        List<String> list = new ArrayList<>();
        list.add("e");
        list.add("f");
        productPrice.setLab

        //choiceBox = new ChoiceBox(FXCollections.observableArrayList(list));
    }

    public void showBox() {
        choiceBox.show();
    }
}

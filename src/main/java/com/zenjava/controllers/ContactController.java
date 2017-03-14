package com.zenjava.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the contact view
 */
public class ContactController {

    @FXML
    private TextField adresse;

    @FXML
    private TextField message;

    @FXML
    private TextField sujet;

    @FXML
    private Button envoyer;

    @FXML
    private Button annuler;

    @FXML
    private void annulerButton() throws IOException {

    }


    @FXML
    private void envoyerButton(){
        Alert alert;
        if (adresse.getCharacters().length() == 0 || sujet.getCharacters().length()== 0 || message.getCharacters().length()== 0){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Informations manquantes");
            alert.setContentText("Il faut remplir toutes les cases");
        }

        else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Message envoyé");
        }
        alert.showAndWait();
    }
}

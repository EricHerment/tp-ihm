package com.zenjava.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller for the contact view
 */
public class ContactController {

    @FXML
    private TextField adresse;

    @FXML
    private TextArea message;

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
        if (adresse.getCharacters().length() == 0 || sujet.getCharacters().length()== 0 || message.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Informations manquantes");
            alert.setContentText("Il faut remplir toutes les cases");
        }
        else if (!isAMail(adresse.getCharacters().toString())){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mauvaise information");
            alert.setContentText("Mauvais format de mail");
        }

        else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Message envoyé");
        }
        alert.showAndWait();
    }

    private boolean isAMail(String texte){
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(texte.toUpperCase());
        return m.matches();

    }
}
